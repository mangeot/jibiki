

create table xslsheets 
(
/* class XslSheet*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    name VARCHAR (255) NOT NULL ,
    dictionaryName VARCHAR (255) NOT NULL ,
    volumeName VARCHAR (255) NOT NULL ,
    description VARCHAR (255) NOT NULL ,
    code TEXT NOT NULL ,
    defaultxsl CHAR (1) NOT NULL ,
    externalxsl CHAR (1) NOT NULL
);




