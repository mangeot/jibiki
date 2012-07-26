

create table contributionlog 
(
/* class ContributionLog*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    author VARCHAR (255) NOT NULL ,
    groups VARCHAR (255) NOT NULL ,
    volume VARCHAR (255) NOT NULL ,
    sourceLanguage VARCHAR (255) NOT NULL ,
    headword VARCHAR (255) NOT NULL ,
    contributionId VARCHAR (255) NOT NULL ,
    entryId VARCHAR (255) NOT NULL ,
    date TIMESTAMP NOT NULL ,
    status VARCHAR (255) NOT NULL
);


CREATE INDEX contributionlog_author_idx ON contributionlog (author);
CREATE INDEX contributionlog_volume_idx ON contributionlog (volume);
CREATE INDEX contributionlog_headword_idx ON contributionlog (headword);
CREATE INDEX contributionlog_contributionid_idx ON contributionlog (contributionId);
CREATE INDEX contributionlog_entryid_idx ON contributionlog (entryId);
CREATE INDEX contributionlog_status_idx ON contributionlog (status);


