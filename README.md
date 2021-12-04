# HexImage
File storage in paper with hexadecimal numbers.

Usage:

File encoding as pdf for printing:

file2pdf.sh file file.pdf

File decoding from scanned image for file recovery:

java -jar HexImage.jar scanned-image.jpeg hex-image.properties | xxd -r -p | bunzip2 > recovered-file