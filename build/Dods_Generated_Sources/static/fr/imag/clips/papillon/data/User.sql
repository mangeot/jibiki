

create table users 
(
/* class User*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    name VARCHAR (255) NOT NULL ,
    login VARCHAR (255) NOT NULL ,
    password BYTEA NOT NULL ,
    email VARCHAR (255) NOT NULL ,
    lang VARCHAR (3) ,
    groups VARCHAR (255) ,
    credits INTEGER NOT NULL ,
    xmlCode TEXT
);


CREATE UNIQUE INDEX users_name_idx ON users (name);
CREATE UNIQUE INDEX users_login_idx ON users (login);


