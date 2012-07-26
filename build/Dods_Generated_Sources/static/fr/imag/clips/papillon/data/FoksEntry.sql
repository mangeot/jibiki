

create table foksentry 
(
/* class FoksEntry*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    headword VARCHAR (255) ,
    reading VARCHAR (255) ,
    id INTEGER ,
    score REAL
);


CREATE INDEX foksentry_reading_idx ON foksentry (reading);


