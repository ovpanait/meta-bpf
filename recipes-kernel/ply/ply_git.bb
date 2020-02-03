DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI = "git://github.com/wkz/ply;protocol=https"
SRCREV = "aa5b9ac31307ec1acece818be334ef801c802a12"

S = "${WORKDIR}/git"

PV = "2.1.0+git${SRCPV}"

inherit autotools autotools-brokensep

DEPENDS = "\
	flex-native \
	bison-native \
	"

BBCLASSEXTEND = "native nativesdk"
