SUMMARY = ""
DESCRIPTION = ""
LICENSE = "GPLv2"

inherit kernelsrc kernel-arch

do_populate_lic[depends] += "virtual/kernel:do_patch"

DEPENDS = "binutils elfutils"

EXTRA_OEMAKE = "V=1 -C ${S}/tools/lib/bpf O=${B}"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

# Fix host-user-contaminated errors:
# QA Issue: libbpf: /usr/lib/libbpf.so.0.0.3 is owned by uid 1002, which is the same as the user running bitbake.
# QA Issue: libbpf: /usr/lib/libbpf.a is owned by uid 1002, which is the same as the user running bitbake.
do_configure_prepend() {
    sed -e "s@cp -fpR@cp -R --no-dereference --preserve=mode,links@g" \
        -i ${S}/tools/lib/bpf/Makefile
}

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake DESTDIR=${D} prefix=${prefix} libdir=${libdir} install
    oe_runmake DESTDIR=${D} prefix=${prefix} libdir=${libdir} install_headers
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

python do_package_prepend() {
    d.setVar('PKGV', d.getVar("KERNEL_VERSION").split("-")[0])
}

B = "${WORKDIR}/${BPN}-${PV}"
