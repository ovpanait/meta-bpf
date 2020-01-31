DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
SRC_URI = "git://github.com/iovisor/bpftrace;protocol=https"
SRCREV = "d3cb095a6ef19388bc33b3d8811d84353be7fff3"

S = "${WORKDIR}/git"

PV = "0.9.3+git${SRCPV}"

inherit cmake

DEPENDS = "\
	bison-native \
	bcc \
	"
do_install_append() {
	install -d ${D}${mandir}
	mv ${D}${prefix}/man/man8 ${D}${mandir}
	rm -rf ${D}${prefix}/man
}

BBCLASSEXTEND = "native nativesdk"
