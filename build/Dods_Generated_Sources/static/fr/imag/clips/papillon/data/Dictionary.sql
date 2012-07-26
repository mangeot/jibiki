

create table dictionaries 
(
/* class Dictionary*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    fullName VARCHAR (255) NOT NULL ,
    name VARCHAR (255) NOT NULL ,
    category VARCHAR (255) NOT NULL ,
    type VARCHAR (255) NOT NULL ,
    domain VARCHAR (255) NOT NULL ,
    legal VARCHAR (255) NOT NULL ,
    sourceLanguages VARCHAR (255) NOT NULL ,
    targetLanguages VARCHAR (255) NOT NULL ,
    xmlCode TEXT NOT NULL
);


CREATE UNIQUE INDEX dictionaries_fullname_idx ON dictionaries (fullname);
CREATE UNIQUE INDEX dictionaries_name_idx ON dictionaries (name);


