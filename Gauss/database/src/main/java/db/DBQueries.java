package db;

import db.util.Constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neerbans on 8/4/17.
 */
public class DBQueries {
    static Map<String, String> queryMap = new HashMap<>();

    static {
        queryMap.put(Constants.MY_SQL + "" + Constants.DB01, "select distinct table_schema from information_schema.TABLES");
        queryMap.put(Constants.MS_SQL + "" + Constants.DB01, "select distinct name from sys.databases");
        queryMap.put(Constants.POST_GRE_SQL + "" + Constants.DB01, "select distinct datname from pg_database where datistemplate = false");
        queryMap.put(Constants.ORACLE + "" + Constants.DB01, "select distinct name from v$database");
        queryMap.put(Constants.H2 + "" + Constants.DB01, "SELECT distinct catalog_name FROM INFORMATION_SCHEMA.SCHEMATA");

        queryMap.put(Constants.POST_GRE_SQL + "" + Constants.TB01, "select table_name from information_schema.tables where is_insertable_into='YES' and table_schema='public' order by table_name");
        queryMap.put(Constants.H2 + "" + Constants.TB01, "SELECT table_name FROM INFORMATION_SCHEMA.TABLES where table_schema = 'PUBLIC' order by table_name");
    }
}
