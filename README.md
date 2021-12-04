# HexImage
File storage in paper with hexadecimal numbers.

## Usage:

### FourBits font installation in Debian

mkdir /usr/share/fonts/truetype/fourbits
cp FourBits.ttf /usr/share/fonts/truetype/fourbits

mkdir /usr/share/fonts/opentype/fourbits/
cp FourBits.otf /usr/share/fonts/opentype/fourbits/

cp FourBits.afm /usr/share/enscript/afm/
vi /usr/share/enscript/afm/font.map

FourBits			FourBits

### File encoding as pdf for printing:

file2pdf.sh file file.pdf

### File decoding from scanned image for file recovery:

java -jar HexImage.jar scanned-image.jpeg hex-image.properties | xxd -r -p | bunzip2 > recovered-file