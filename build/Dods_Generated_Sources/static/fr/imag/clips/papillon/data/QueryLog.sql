

create table querylogs 
(
/* class QueryLog*/
    ObjectId DECIMAL (19,0) NOT NULL PRIMARY KEY ,
    ObjectVersion INTEGER  NOT NULL ,
    date DATE NOT NULL ,
    login VARCHAR (255) NOT NULL ,
    formName VARCHAR (50) NOT NULL ,
    prefLang VARCHAR (3) NOT NULL ,
    query VARCHAR (255) NOT NULL ,
    results TEXT ,
    srcLang VARCHAR (3) NOT NULL ,
    trgLangs VARCHAR (512) NOT NULL ,
    dicts VARCHAR (1024) NOT NULL ,
    strategy VARCHAR (255) NOT NULL ,
    queryString TEXT NOT NULL
);


CREATE INDEX querylogs_login_idx ON querylogs (login);
CREATE INDEX querylogs_formName_idx ON querylogs (formName);
CREATE INDEX querylogs_query_idx ON querylogs (query);
CREATE INDEX querylogs_queryString_idx ON querylogs (queryString);


