#!/bin/sh

installdir=$(pwd)

sed -i "s#\%ADMIN_PASSWORD\%#$ADMIN_PASSWORD#g" $installdir/papillon.properties

sed -i "s#\%SPECIALIST_PASSWORD\%#$SPECIALIST_PASSWORD#g" $installdir/papillon.properties

sed -i "s#\%DATABASE_NAME\%#$DATABASE_NAME#g" $installdir/papillon.properties

sed -i "s#\%DATABASE_USER\%#$DATABASE_USER#g" $installdir/papillon.properties

sed -i "s#\%DATABASE_PASSWORD\%#$DATABASE_PASSWORD#g" $installdir/papillon.properties

$installdir/output/run --debug --exec