

create table papillonaxi 
(
/* class PapillonAxi*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    id VARCHAR (255) ,
    semanticCat VARCHAR (255) ,
    dom BYTEA NOT NULL ,
    htmldom BYTEA ,
    xmlCode TEXT NOT NULL ,
    lexies BYTEA NOT NULL ,
    synonyms VARCHAR (255)
);


CREATE INDEX papillonaxi_id_idx ON papillonaxi (id);


