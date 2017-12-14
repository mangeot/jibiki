INSTALLING POSTGRESQL
---------------------

- Install postgresql 8.x

DATABASE PREPARATION
- createdb with owner lexalp (pass specified in conf). ENCODING=UNICODE
- Create database by evaluating SQLcreate.sql of dods_static generated files.
- createlang -L /usr/local/pgsql/lib -d lexalp plpgsql
- add multilingual sort functions by evaluating file src/sql/multilingual-sort.sql

CREATING LEXALP ADMIN USER
- launch lexalp server locally (./run --exec --debug)
- goto: http://localhost:8999/Register.po and identify  yourself
- open User Profile, add user to group admin, using group password specified in conf file.

SETTING UP LEXALP SERVER
- add XML stylesheet into the database (using xsl sheets page)
  (file is found in src/fr/imag/clips/papillon/resources/xsl/)
  [THIS IS NOT THE DEFAULT XSL...]