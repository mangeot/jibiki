#!/bin/sh

curl -vvv -X DELETE \
    -u mangeot:michan \
    "https://jibiki.fr/jibiki/api/Cesselin/jpn/$1"
