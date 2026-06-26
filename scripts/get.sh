#!/bin/sh

curl -X GET \
    -u mangeot:michan \
    -H "Content-Type: application/xml;charset=UTF-8" \
    -H "Accept: application/xml" \
    "https://jibiki.fr/jibiki/api/Cesselin/jpn/handle/$1";
