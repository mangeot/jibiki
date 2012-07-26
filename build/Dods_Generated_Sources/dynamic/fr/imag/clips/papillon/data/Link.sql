

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


