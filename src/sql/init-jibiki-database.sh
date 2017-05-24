#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE USER $DATABASE_USER WITH PASSWORD '$DATABASE_PASSWORD' CREATEDB;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$DATABASE_USER" "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE $DATABASE_NAME WITH ENCODING 'UTF-8';
EOSQL

psql -v ON_ERROR_STOP=1 --username $DATABASE_USER $DATABASE_NAME -f sql/multilingual-sort.sql

psql -v ON_ERROR_STOP=1 --username $DATABASE_USER $DATABASE_NAME -f sql/SQLcreate.sql

