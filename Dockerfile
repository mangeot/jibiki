############################################################
# Dockerfile to build Jibiki lexical database server container images
# Based on openjdk
############################################################

FROM openjdk

MAINTAINER Mathieu Mangeot

ARG ADMIN_PASSWORD="dbpap"
ARG VALIDATOR_PASSWORD="butterfly"
ARG SPECIALIST_PASSWORD="farfalla"
ARG DATABASE_HOST="postgres"
ARG DATABASE_NAME="jibiki"
ARG DATABASE_USER="jibiki"
ARG DATABASE_PASSWORD="dbjibiki2"

ENV ADMIN_PASSWORD=$ADMIN_PASSWORD
ENV VALIDATOR_PASSWORD=VALIDATOR_PASSWORD
ENV SPECIALIST_PASSWORD=SPECIALIST_PASSWORD
ENV DATABASE_HOST=$DATABASE_HOST
ENV DATABASE_NAME=$DATABASE_NAME
ENV DATABASE_USER=$DATABASE_USER
ENV DATABASE_PASSWORD=$DATABASE_PASSWORD


RUN apt-get update

RUN apt-get install -y libpostgresql-jdbc-java

WORKDIR /

RUN git clone https://gricad-gitlab.univ-grenoble-alpes.fr/mmang/toolsforjibiki.git

WORKDIR toolsforjibiki

RUN for file in *.tar.gz; do tar -zxf $file; done

WORKDIR enhydra5.1

RUN ./configure -Djdk.dir=/usr

RUN chmod 755 bin/ant

RUN sed -i "s#CLASSPATH=#CLASSPATH=/toolsforjibiki/xalan-j_2_4_1/bin/xalan.jar:#" bin/ant

RUN cp ../xmlc-2.2.13/lib/xmlc.jar lib/.

RUN chmod -R 777 dods/build/template/standard/*

RUN chmod 777 dods/build/dods.properties

WORKDIR /

#RUN git clone https://github.com/mangeot/jibiki.git

#WORKDIR jibiki

RUN cp papillon.properties.in papillon.properties

RUN sed -i "s#\%TOOLSFORJIBIKI_DIR\%#/toolsforjibiki#g" papillon.properties

RUN sed -i "s#\%ADMIN_PASSWORD\%#$ADMIN_PASSWORD#g" papillon.properties

RUN sed -i "s#\%SPECIALIST_PASSWORD\%#$SPECIALIST_PASSWORD#g" papillon.properties

RUN sed -i "s#\%DATABASE_HOST\%#$DATABASE_HOST#g" papillon.properties

RUN sed -i "s#\%DATABASE_NAME\%#$DATABASE_NAME#g" papillon.properties

RUN sed -i "s#\%DATABASE_USER\%#$DATABASE_USER#g" papillon.properties

RUN sed -i "s#\%DATABASE_PASSWORD\%#$DATABASE_PASSWORD#g" papillon.properties

RUN chmod 755 docker-entrypoint.sh

RUN export LC_ALL=en_US.UTF-8

RUN /toolsforjibiki/enhydra5.1/bin/ant make

##################### INSTALLATION END #####################

# Expose the default port
EXPOSE 8999

# Set default container command
#ENTRYPOINT /jibiki/output/run --debug --exec

#ENTRYPOINT /jibiki/docker-entrypoint.sh
ENTRYPOINT /docker-entrypoint.sh

