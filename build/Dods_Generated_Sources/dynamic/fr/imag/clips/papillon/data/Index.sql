

create table index 
(
/* class Index*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    key VARCHAR (255) ,
    lang VARCHAR (3) ,
    value VARCHAR (255) ,
    msort VARCHAR (255) ,
    entryId  NOT NULL
);


CREATE INDEX index_key_idx ON index (key, lang, value);
CREATE INDEX index_entryid_idx ON index (entryId);
CREATE INDEX index_msort_idx ON index (msort);


