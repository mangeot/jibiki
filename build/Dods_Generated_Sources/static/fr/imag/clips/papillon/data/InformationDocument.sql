

create table informationdocument 
(
/* class InformationDocument*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    author TEXT ,
    owner VARCHAR (255) NOT NULL ,
    reference TEXT ,
    creationDate DATE NOT NULL ,
    section VARCHAR (255) ,
    title TEXT
);




