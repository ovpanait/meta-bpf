DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e3fc50a88d0a364313df4b21ef20c29e"
SRC_URI = "git://github.com/iovisor/bcc;protocol=https"
SRCREV = "0cafe5571865d4dcab8ff2bd398b41dbc10b42f4"

S = "${WORKDIR}/git"

PV = "0.12.0+git${SRCPV}"

inherit cmake python3native

SRC_URI += " \
	    file://0001-python-CMakeLists.txt-Remove-check-for-host-etc-debi.patch \
	    "

EXTRA_OECMAKE += "-DCMAKE_USE_LIBBPF_PACKAGE=ON -DPYTHON_CMD=${PYTHON}"

DEPENDS = "\
	libbpf \
	clang \
	bison-native \
	"

do_install_append() {
	sed -e 's@#!/usr/bin/python@#!/usr/bin/env python3@g' \
	    -e 's@#!/bin/bash@#!/bin/sh@g' \
            -i $(find ${D}${datadir}/${PN} -type f)
}

RDEPENDS_${PN} += " \
        python3-core \
	python3-modules \
	"

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}"

