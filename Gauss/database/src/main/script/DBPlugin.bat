@REM ----------- All rights reserved ----------
@ECHO OFF

@REM --- conf must come before lib otherwise it would not read properties from external file
:: java -cp "../conf/;../lib/*" db.DBInfo

::set a environment variable name DB_HOME till the project path and add %DB_HOME%/target/db-dist/bin in the path variable

set "location=%DB_HOME%/target/db-dist/db"

java -cp "%location%/conf/;%location%/lib/*" db.DBInfo