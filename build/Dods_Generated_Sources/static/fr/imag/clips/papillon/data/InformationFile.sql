

create table informationfiles 
(
/* class InformationFile*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    filename TEXT NOT NULL ,
    filetype TEXT NOT NULL ,
    document DECIMAL (19,0) NOT NULL ,
    filecode TEXT ,
    isIndexFile CHAR (1) NOT NULL ,
    language VARCHAR (5) NOT NULL ,    
    CONSTRAINT informationfiles_document FOREIGN KEY (document) REFERENCES informationdocument (ObjectId)
);




