#!/bin/sh

curl -X POST \
    -u mangeot:michan \
    -H "Content-Type: application/xml;charset=UTF-8" \
    -H "Accept: application/xml" \
    -d "@entry.xml"\
    "https://jibiki.fr/jibiki/api/Cesselin/jpn/$1";
