

create table messages 
(
/* class Message*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    date DATE NOT NULL ,
    msg TEXT NOT NULL ,
    msgid VARCHAR (127) NOT NULL ,
    subject VARCHAR (255) NOT NULL ,
    author VARCHAR (255) NOT NULL ,
    authorAddress VARCHAR (255) NOT NULL ,
    thread VARCHAR (255) NOT NULL
);


CREATE UNIQUE INDEX messages_msgid_idx ON messages (msgid);


