package db;


import db.util.Code;
import db.util.Constants;
import db.util.DB;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by neerbans on 8/4/17.
 */
public class DBInfo {

    private static Logger logger = Logger.getLogger(DBInfo.class);
    private static Properties props = null;
    private static DBConnection dbConnection = null;

    public DBInfo() {
        dbConnection = new DBConnection(props);
    }

    public static void main(String args[]) {
        Connection conn = null;
        try {
            // we can also use ResourceBundle here, ResourceBundle rb = ResourceBundle.getBundle("claim-conf");
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("db.properties");
            props = new Properties();
            props.load(inputStream);
            DBInfo obj = new DBInfo();
            String dbType = props.getProperty("db");
            try {
                logger.info("you have chosen : " + dbType + " database");
                DB.valueOf(dbType);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("please choose a valid database type, database must be one of these " + Arrays.toString(DB.values()));
            }
            conn = dbConnection.getDBConnection(dbType);
            Statement sta = conn.createStatement();
            String code = props.getProperty("code");
            try {
                logger.info("you have chosen : " + code + " code");
                Code.valueOf(code);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("please choose a valid code, code must be one of these " + Arrays.toString(Code.values()));
            }
            obj.execute(sta, code, dbType);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void execute(Statement sta, String code, String dbType) throws SQLException {
        DBResult dbResult = new DBResult();
        switch (code) {
            case Constants.DB01:
            case Constants.TB01:
                dbResult.getDBTableInfo(sta, code, dbType);
                break;
            case Constants.RE01:
                dbResult.getAllRecords(sta, props.getProperty(Constants.TABLE_NAME));
                dbResult.getAllRecords(sta, props.getProperty(Constants.TABLE_NAME));
                break;
            case Constants.FL01:
                executeFile(sta);
                break;
            default:
                throw new RuntimeException("wrong code " + code);
        }
    }

    private void executeFile(Statement sta) throws SQLException {
        try {
            DBResult dbResult = new DBResult();
            Boolean b = Boolean.parseBoolean(props.getProperty("see_result_set"));

            InputStream inputStream = ClassLoader.getSystemResourceAsStream("script/scripts.sql");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append(" ");
            }
            br.close();
            String stats[] = sb.toString().split(";");
            for (String stat : stats) {
                if (stat.trim().length() > 0) {
                    logger.info("Executing statement : " + stat);
//                    System.out.println(stat);
                    if (b) {
                        ResultSet rs = sta.executeQuery(stat);
                        dbResult.showResultSet(rs);
                    }
                    else {
                        sta.execute(stat);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
