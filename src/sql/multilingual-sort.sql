-- $Id$
-- in order to load this function, execute: createlang plpgsql papillon
-- then use as is:
-- select headword from gdefest order by est_sort(headword);
-- or create an index:
--


-- axi interlingual link
--
-- for the moment do nothing
CREATE OR REPLACE FUNCTION axi_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );


-- deu German
-- (a ä) b c d e f g h i j k l m n (o ö) p q r (s ß) t (u ü) v w x y z
-- for the moment do nothing
-- todo: umlaut and other diacritics ...

CREATE OR REPLACE FUNCTION deu_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
 i		integer;
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
 	length := char_length($1);
  	FOR i IN 1.. length LOOP
  		tmp := SUBSTR( $1, i, 1 );
  IF tmp = ''A''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''a''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''À'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''à'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''Â'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''â'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''Ä'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''ä'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''B'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''b'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''C'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''c'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''Ç'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''ç'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''D'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''d'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''E'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''e'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''É'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''é'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''È'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''è'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''Ê'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''ê'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''Ë'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''ë'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''F'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''f'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''G'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''g'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''H'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''h'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''I'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''i'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''Î'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''î'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''Ï'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''ï'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''J'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''j'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''K'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''k'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''L'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''l'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''M'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''m'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''N'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''n'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''O'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''o'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''Ö'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''ö'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''ô'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''Ô'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''p'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''P'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''Q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''R'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''r'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''S'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''s'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''ß'' THEN
    result:= result || ''1919'';
  ELSIF tmp = ''T'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''t'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''U'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''u'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Ù'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ù'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Û'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''û'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Ü'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ü'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''V'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''v'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''W'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''w'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''X'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''x'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''Y'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''y'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''Z'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''z'' THEN
    result:= result || ''27'';
  ELSIF tmp = '' '' THEN
    result:= result;
  ELSIF tmp = ''-'' THEN
    result:= result;
  ELSIF tmp = ''#'' THEN
    result:= result;
  ELSE
    result:= result || ''99'';
  END IF;
	END LOOP;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );




-- eng English
-- a b c d e f g h i j k l m n o p q r s t u v w x y z
-- for the moment do nothing; probably ok as is
CREATE OR REPLACE FUNCTION eng_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );




-- est Estonian
-- a ç b c d e f g h i j k l m n o p q r s š z ž t u v w õ ä ö ü x y

CREATE OR REPLACE FUNCTION est_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
 	length = char_length($1);
  	FOR i IN 1.. length LOOP
  		tmp := SUBSTR( $1, i, 1 );
  IF tmp = ''A''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''a''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''À''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''à''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''B'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''b'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''C'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''c'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''D'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''d'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''e'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''E'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''F'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''f'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''G'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''g'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''H'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''h'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''I'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''i'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''J'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''j'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''K'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''k'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''L'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''l'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''M'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''m'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''N'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''n'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''O'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''o'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''P'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''p'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''Q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''R'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''r'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''S'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''s'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''Š'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''š'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''Z'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''z'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Ž'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''ž'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''T'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''t'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''U'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''u'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''V'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''v'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''W'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''w'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''Õ'' THEN
    result:= result || ''28'';
  ELSIF tmp = ''õ'' THEN
    result:= result || ''28'';
  ELSIF tmp = ''Ä'' THEN
    result:= result || ''29'';
  ELSIF tmp = ''ä'' THEN
    result:= result || ''29'';
  ELSIF tmp = ''Ö'' THEN
    result:= result || ''30'';
  ELSIF tmp = ''ö'' THEN
    result:= result || ''30'';
  ELSIF tmp = ''Ü'' THEN
    result:= result || ''31'';
  ELSIF tmp = ''ü'' THEN
    result:= result || ''31'';
  ELSIF tmp = ''X'' THEN
    result:= result || ''32'';
  ELSIF tmp = ''x'' THEN
    result:= result || ''32'';
  ELSIF tmp = ''Y'' THEN
    result:= result || ''33'';
  ELSIF tmp = ''y'' THEN
    result:= result || ''33'';
  ELSIF tmp = '' '' THEN
    result:= result;
  ELSIF tmp = ''-'' THEN
    result:= result;
  ELSIF tmp = ''+'' THEN
    result:= result;
  ELSIF tmp = ''\''' THEN
    result:= result;
  ELSIF tmp = ''\''' THEN
    result:= result;
  ELSIF tmp = ''#'' THEN
    result:= result;
  ELSE
    result:= result || ''99'';
  END IF;
	END LOOP;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- fra French
-- (a à ä â) b (c ç) d (e é è ë ê) f g h (i ï î) j k l m n (o ö ô) p q r s t (u ù ü û) v w x y z

CREATE OR REPLACE FUNCTION fra_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
 i		integer;
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
 	length := char_length($1);
  	FOR i IN 1.. length LOOP
  		tmp := SUBSTR( $1, i, 1 );
  IF tmp = ''A''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''a''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''À'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''à'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''Â'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''â'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''Ä'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''ä'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''B'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''b'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''C'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''c'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''Ç'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''ç'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''D'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''d'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''E'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''e'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''É'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''é'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''È'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''è'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''Ê'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''ê'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''Ë'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''ë'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''F'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''f'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''G'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''g'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''H'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''h'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''I'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''i'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''Î'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''î'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''Ï'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''ï'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''J'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''j'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''K'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''k'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''L'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''l'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''M'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''m'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''N'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''n'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''O'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''o'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''Ö'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''ö'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''ô'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''Ô'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''p'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''P'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''Q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''R'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''r'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''S'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''s'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''T'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''t'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''U'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''u'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Ù'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ù'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Û'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''û'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Ü'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ü'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''V'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''v'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''W'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''w'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''X'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''x'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''Y'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''y'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''Z'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''z'' THEN
    result:= result || ''27'';
  ELSIF tmp = '' '' THEN
    result:= result;
  ELSIF tmp = ''-'' THEN
    result:= result;
  ELSIF tmp = ''+'' THEN
    result:= result;
  ELSIF tmp = ''#'' THEN
    result:= result;
  ELSE
    result:= result || ''99'';
  END IF;
	END LOOP;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );

-- ita Italian
--
-- for the moment do nothing
-- todo: maybe italian sort 
CREATE OR REPLACE FUNCTION ita_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- jpn Japanese
--
-- romaji katakana hiragana kanji
-- for the moment do nothing
-- todo: maybe sort with unicode code or reading 
CREATE OR REPLACE FUNCTION jpn_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- kor Korean
-- 
-- for the moment do nothing
-- todo: maybe sort by unicode code
CREATE OR REPLACE FUNCTION kor_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- msa Malay
-- a b c d e f g h i j k l m n o p q r s t u v w x y z
-- for the moment do nothing; probably ok as is
CREATE OR REPLACE FUNCTION msa_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- slo Slovene
--
-- for the moment do nothing
-- todo: maybe slovene sort 
CREATE OR REPLACE FUNCTION slo_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- tha Thai
-- 
-- for the moment do nothing
-- todo: maybe sort by unicode code
CREATE OR REPLACE FUNCTION tha_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- vie Vietnamese
-- a b c d e f g h i j k l m n o p q r s t u v w x y z
-- for the moment do nothing
-- todo: umaybe sort by unicode code or suppress diacritics ...
CREATE OR REPLACE FUNCTION vie_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- zho Chinese
-- for the moment do nothing
-- todo: sort by unicode code or reading...
CREATE OR REPLACE FUNCTION zho_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
  return( $1 );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );



-- test (est Estonian)
-- a ç b c d e f g h i j k l m n o p q r s š z ž t u v w õ ä ö ü x y

CREATE OR REPLACE FUNCTION tes_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
 	length = char_length($1);
  	FOR i IN 1.. length LOOP
  		tmp := SUBSTR( $1, i, 1 );
  IF tmp = ''A''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''a''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''À''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''à''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''B'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''b'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''C'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''c'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''D'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''d'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''e'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''E'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''F'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''f'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''G'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''g'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''H'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''h'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''I'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''i'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''J'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''j'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''K'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''k'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''L'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''l'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''M'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''m'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''N'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''n'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''O'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''o'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''P'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''p'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''Q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''R'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''r'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''S'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''s'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''Š'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''š'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''Z'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''z'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''Ž'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''ž'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''T'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''t'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''U'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''u'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''V'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''v'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''W'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''w'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''Õ'' THEN
    result:= result || ''28'';
  ELSIF tmp = ''õ'' THEN
    result:= result || ''28'';
  ELSIF tmp = ''Ä'' THEN
    result:= result || ''29'';
  ELSIF tmp = ''ä'' THEN
    result:= result || ''29'';
  ELSIF tmp = ''Ö'' THEN
    result:= result || ''30'';
  ELSIF tmp = ''ö'' THEN
    result:= result || ''30'';
  ELSIF tmp = ''Ü'' THEN
    result:= result || ''31'';
  ELSIF tmp = ''ü'' THEN
    result:= result || ''31'';
  ELSIF tmp = ''X'' THEN
    result:= result || ''32'';
  ELSIF tmp = ''x'' THEN
    result:= result || ''32'';
  ELSIF tmp = ''Y'' THEN
    result:= result || ''33'';
  ELSIF tmp = ''y'' THEN
    result:= result || ''33'';
  ELSIF tmp = '' '' THEN
    result:= result;
  ELSIF tmp = ''-'' THEN
    result:= result;
  ELSIF tmp = ''+'' THEN
    result:= result;
  ELSIF tmp = ''#'' THEN
    result:= result;
  ELSE
    result:= result || ''99'';
  END IF;
	END LOOP;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );




-- multilingual sort
CREATE OR REPLACE FUNCTION multilingual_sort( varchar,varchar ) 
 RETURNS varchar AS '

 DECLARE
  lang	varchar;
  word	varchar;
  result	varchar := '''';
 BEGIN
  lang := $1;
  word := $2;
   IF lang = ''deu'' THEN
    result:= deu_sort(word);
  ELSIF lang = ''eng'' THEN
    result:= eng_sort(word);
  ELSIF lang = ''eng'' THEN
    result:= est_sort(word);
  ELSIF lang = ''fra'' THEN
    result:= fra_sort(word);
  ELSIF lang = ''jpn'' THEN
    result:= jpn_sort(word);
  ELSIF lang = ''kor'' THEN
    result:= kor_sort(word);
 ELSIF lang = ''msa'' THEN
    result:= msa_sort(word);
 ELSIF lang = ''tha'' THEN
    result:= tha_sort(word);
 ELSIF lang = ''vie'' THEN
    result:= vie_sort(word);
 ELSIF lang = ''zho'' THEN
    result:= zho_sort(word);
 ELSE 
    result:= word;
 END IF;
  result := lang || result;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );

