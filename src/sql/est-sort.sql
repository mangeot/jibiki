-- in order to load this function, execute: createlanguage plpgsql papillon
-- then use as is:
-- select headword from gdefest order by est_sort(headword);
-- or create an index:
--
-- a b c d e f g h i j k l m n o p q r s š z ž t u v w õ ä ö ü x y

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
  IF tmp = ''a''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''b'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''c'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''d'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''e'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''f'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''g'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''h'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''i'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''j'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''k'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''l'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''m'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''n'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''o'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''p'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''r'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''s'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''š'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''z'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ž'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''t'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''u'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''v'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''w'' THEN
    result:= result || ''27'';
  ELSIF tmp = ''õ'' THEN
    result:= result || ''28'';
  ELSIF tmp = ''ä'' THEN
    result:= result || ''29'';
  ELSIF tmp = ''ö'' THEN
    result:= result || ''30'';
  ELSIF tmp = ''ü'' THEN
    result:= result || ''31'';
  ELSIF tmp = ''x'' THEN
    result:= result || ''32'';
  ELSIF tmp = ''y'' THEN
    result:= result || ''33'';
  ELSIF tmp = '' '' THEN
    result:= result;
  ELSIF tmp = ''#'' THEN
    result:= result;
  ELSE
    result:= result || ''00'';
  END IF;
	END LOOP;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );

-- à a b c d e é è ë ê f g h i j k l m n o p q r s  z  t u v w õ ä ö ü x y

CREATE OR REPLACE FUNCTION fra_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result	varchar := '''';
  length	integer;
 BEGIN
 	length = char_length($1);
  	FOR i IN 1.. length LOOP
  		tmp := SUBSTR( $1, i, 1 );
  IF tmp = ''a''  THEN
    result:= result || ''01'';
  ELSIF tmp = ''à'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''â'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''ä'' THEN
    result:= result || ''01'';
  ELSIF tmp = ''b'' THEN
    result:= result || ''02'';
  ELSIF tmp = ''c'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''ç'' THEN
    result:= result || ''03'';
  ELSIF tmp = ''d'' THEN
    result:= result || ''04'';
  ELSIF tmp = ''e'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''é'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''è'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''ê'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''ë'' THEN
    result:= result || ''05'';
  ELSIF tmp = ''f'' THEN
    result:= result || ''06'';
  ELSIF tmp = ''g'' THEN
    result:= result || ''07'';
  ELSIF tmp = ''h'' THEN
    result:= result || ''08'';
  ELSIF tmp = ''i'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''î'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''ï'' THEN
    result:= result || ''09'';
  ELSIF tmp = ''j'' THEN
    result:= result || ''10'';
  ELSIF tmp = ''k'' THEN
    result:= result || ''11'';
  ELSIF tmp = ''l'' THEN
    result:= result || ''12'';
  ELSIF tmp = ''m'' THEN
    result:= result || ''13'';
  ELSIF tmp = ''n'' THEN
    result:= result || ''14'';
  ELSIF tmp = ''o'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''ö'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''ô'' THEN
    result:= result || ''15'';
  ELSIF tmp = ''p'' THEN
    result:= result || ''16'';
  ELSIF tmp = ''q'' THEN
    result:= result || ''17'';
  ELSIF tmp = ''r'' THEN
    result:= result || ''18'';
  ELSIF tmp = ''s'' THEN
    result:= result || ''19'';
  ELSIF tmp = ''t'' THEN
    result:= result || ''20'';
  ELSIF tmp = ''u'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ù'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''û'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''ü'' THEN
    result:= result || ''22'';
  ELSIF tmp = ''v'' THEN
    result:= result || ''23'';
  ELSIF tmp = ''w'' THEN
    result:= result || ''24'';
  ELSIF tmp = ''x'' THEN
    result:= result || ''25'';
  ELSIF tmp = ''y'' THEN
    result:= result || ''26'';
  ELSIF tmp = ''z'' THEN
    result:= result || ''27'';
  ELSIF tmp = '' '' THEN
    result:= result;
  ELSIF tmp = ''#'' THEN
    result:= result;
  ELSE
    result:= result || ''00'';
  END IF;
	END LOOP;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );
