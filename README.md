# HexImage
File storage in paper with hexadecimal numbers and four bits font.

## Usage:

### FourBits font installation in Debian

\# mkdir /usr/share/fonts/truetype/fourbits\
\# cp FourBits.ttf /usr/share/fonts/truetype/fourbits

\# mkdir /usr/share/fonts/opentype/fourbits\
\# cp FourBits.otf /usr/share/fonts/opentype/fourbits

\# cp FourBits.afm /usr/share/enscript/afm\
\# vi /usr/share/enscript/afm/font.map

FourBits&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FourBits

<img src="https://media.cuadernoinformatica.com/imagenes/grabacion-de-archivos-en-papel/fontforge-tipo-letra-four-bits.jpg"/>

### File encoding as PDF for printing:

\# file2pdf.sh file file.pdf

<img src="https://media.cuadernoinformatica.com/imagenes/grabacion-de-archivos-en-papel/atril-archivo-pdf-hexadecimal-fourbits.jpg"/>

### File decoding from scanned image for file recovery:

\# java -jar HexImage.jar scanned-image.jpeg hex-image.properties | xxd -r -p | bunzip2 > recovered-file

More info in <a href="https://www.cuadernoinformatica.com/2021/12/grabacion-de-archivos-en-papel.html">"Grabación de Archivos en Papel"</a> blog article.