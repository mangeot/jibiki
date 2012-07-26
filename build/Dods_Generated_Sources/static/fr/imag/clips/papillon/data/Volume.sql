

create table volumes 
(
/* class Volume*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    name VARCHAR (255) NOT NULL ,
    dictname VARCHAR (255) NOT NULL ,
    dbname VARCHAR (255) NOT NULL ,
    location VARCHAR (255) NOT NULL ,
    sourceLanguage VARCHAR (3) NOT NULL ,
    targetLanguages VARCHAR (255) NOT NULL ,
    volumeRef VARCHAR (255) NOT NULL ,
    xmlCode TEXT NOT NULL ,
    xmlSchema TEXT ,
    templateItf TEXT ,
    templateEntry TEXT ,
    reverse CHAR (1) NOT NULL ,
    entries INTEGER NOT NULL
);


CREATE UNIQUE INDEX volumes_name_idx ON volumes (name);
CREATE INDEX volumes_dictname_idx ON volumes (dictname);
CREATE INDEX volumes_dbname_idx ON volumes (dbname);


