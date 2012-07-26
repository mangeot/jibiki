

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




create table link 
(
/* class Link*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    targetId VARCHAR (255) ,
    lang VARCHAR (3) ,
    volumeTarget VARCHAR (255) ,
    weight  ,
    type VARCHAR (255) ,
    label VARCHAR (255) ,
    entryId  NOT NULL
);


CREATE INDEX link_entryid_idx ON link (entryId);




create table volume 
(
/* class VolumeEntry*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    headword TEXT ,
    xmlCode TEXT NOT NULL
);







create table objectid
(
    next DECIMAL (19,0) NOT NULL PRIMARY KEY
);
