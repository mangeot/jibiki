Description
=============

Jibiki is a generic platform for managing lexical resources online.
Any resource in XML format can be imported and then queried and edited online.
The platform uses the Enhydra object web framework and Postgres database for the data layer.

For running examples, see:
- http://www.estfra.ee/
- http://papillon.imag.fr/
- http://jibiki.fr/

There is also a REST API for remote programming. See
http://papillon.imag.fr/Api.po

Installation
=============

The easiest way to install is to use the dockerfiles.

The jibiki dockerfile is built upon openjdk 8 official image: https://hub.docker.com/_/openjdk/
The postgres4jibiki dockerfile is built upon postgresql latest official image.
See https://hub.docker.com/r/mangeot/postgres4jibiki/

Getting the latest docker image:
-------------
docker pull mangeot/postgres4jibiki
docker pull mangeot/jibiki

or compiling from the git repos
-------------
docker build -t mangeot/postgres4jibiki github.com/mangeot/postgres4jibiki
docker build -t mangeot/jibiki github.com/mangeot/jibiki

Running the docker images
-------------
docker run --name jibiki-database -d mangeot/postgres4jibiki postgres
docker run --name myjibiki -p 8999:8999 --link jibiki-database:postgres -d mangeot/jibiki



