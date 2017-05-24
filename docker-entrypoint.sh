#!/bin/sh

WORKDIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

sed -i "s#\%ADMIN_PASSWORD\%#$ADMIN_PASSWORD#g" $WORKDIR/papillon.properties

sed -i "s#\%SPECIALIST_PASSWORD\%#$SPECIALIST_PASSWORD#g" $WORKDIR/papillon.properties

sed -i "s#\%DATABASE_HOST\%#$DATABASE_HOST#g" $WORKDIR/papillon.properties

sed -i "s#\%DATABASE_NAME\%#$DATABASE_NAME#g" $WORKDIR/papillon.properties

sed -i "s#\%DATABASE_USER\%#$DATABASE_USER#g" $WORKDIR/papillon.properties

sed -i "s#\%DATABASE_PASSWORD\%#$DATABASE_PASSWORD#g" $WORKDIR/papillon.properties

$WORKDIR/output/run --debug --exec
