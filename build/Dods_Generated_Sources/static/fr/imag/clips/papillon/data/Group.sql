

create table groups 
(
/* class Group*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    name VARCHAR (255) NOT NULL ,
    password BYTEA NOT NULL ,
    users TEXT ,
    admins TEXT
);


CREATE UNIQUE INDEX groups_name_idx ON groups (name);


