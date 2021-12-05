#! /bin/bash

bzip2 -c $1 | xxd -u -p -c 73 | enscript -B -f FourBits4 --margins=0:0:0:0 -p - | ps2pdf - $2