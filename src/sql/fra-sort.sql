CREATE OR REPLACE FUNCTION fra_sort( varchar ) 
 RETURNS varchar AS '

 DECLARE
  tmp		varchar;
  result		varchar := ''tt'';
  cmp		varchar := ''a'';
 BEGIN
  
  tmp := SUBSTR( $1, 1, 1 );
  IF tmp = ''a''  THEN
    result:=result + ''01'';
  ELSIF tmp = ''b'' THEN
    result:=result + ''02'';
  ELSIF tmp = ''c'' THEN
    result:=result + ''03'';
  ELSIF tmp = ''d'' THEN
    result:=result + ''04'';
  ELSE
    result:=result + ''00'';
  END IF;
  return( result );
 END;
' LANGUAGE 'plpgsql' WITH ( ISCACHABLE );
