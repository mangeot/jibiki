ALTER TABLE informationfiles DROP CONSTRAINT informationfiles_document ;

DROP INDEX contributionlog_author_idx ;
DROP INDEX contributionlog_volume_idx ;
DROP INDEX contributionlog_headword_idx ;
DROP INDEX contributionlog_contributionid_idx ;
DROP INDEX contributionlog_entryid_idx ;
DROP INDEX contributionlog_status_idx ;
DROP INDEX dictionaries_fullname_idx ;
DROP INDEX dictionaries_name_idx ;
DROP INDEX messages_msgid_idx ;
DROP INDEX groups_name_idx ;
DROP INDEX querylogs_login_idx ;
DROP INDEX querylogs_formName_idx ;
DROP INDEX querylogs_query_idx ;
DROP INDEX querylogs_queryString_idx ;
DROP INDEX papillonaxi_id_idx ;
DROP INDEX volumes_name_idx ;
DROP INDEX volumes_dictname_idx ;
DROP INDEX volumes_dbname_idx ;
DROP INDEX foksentry_reading_idx ;
DROP INDEX users_name_idx ;
DROP INDEX users_login_idx ;

DROP TABLE contributionlog ;
DROP TABLE dictionaries ;
DROP TABLE informationdocument ;
DROP TABLE messages ;
DROP TABLE jibikiversion ;
DROP TABLE groups ;
DROP TABLE querylogs ;
DROP TABLE xslsheets ;
DROP TABLE informationfiles ;
DROP TABLE papillonaxi ;
DROP TABLE volumes ;
DROP TABLE foksentry ;
DROP TABLE users ;

DROP TABLE objectid ;
