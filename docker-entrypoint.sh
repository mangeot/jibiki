#!/bin/sh

sed -i "s#\%ADMIN_PASSWORD\%#/$ADMIN_PASSWORD#g" /LINKS_1_0/papillon.properties

sed -i "s#\%SPECIALIST_PASSWORD\%#/$SPECIALIST_PASSWORD#g" /LINKS_1_0/papillon.properties

sed -i "s#\%DATABASE_NAME\%#/$DATABASE_NAME#g" papillon.properties

sed -i "s#\%DATABASE_USER\%#/$DATABASE_USER#g" papillon.properties

sed -i "s#\%DATABASE_PASSWORD\%#/$DATABASE_PASSWORD#g" papillon.properties

output/run --debug --exec