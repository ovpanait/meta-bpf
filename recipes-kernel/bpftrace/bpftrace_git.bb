DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
SRC_URI = "git://github.com/iovisor/bpftrace;protocol=https"
SRCREV = "2667b8a2e1c22613e731c7b68d66e742a58f2249"

S = "${WORKDIR}/git"

PV = "0.9.4+git${SRCPV}"

inherit cmake

DEPENDS = "\
	bison-native \
	bcc \
	"
