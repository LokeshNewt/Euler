package db;


import db.result.DBResult;
import db.result.IResult;
import db.store.IExecute;
import db.store.ExecuteImpl;
import db.util.Code;
import db.util.Constants;
import db.util.DB;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
        IResult dbResult = new DBResult();
        IExecute exe = new ExecuteImpl(dbResult);
        switch (code) {
            case Constants.DB01:
            case Constants.TB01:
                exe.getDBTableInfo(sta, code, dbType);
                break;
            case Constants.RE01:
                exe.getAllRecords(sta, props.getProperty(Constants.TABLE_NAME));
                break;
            case Constants.FL01:
                exe.executeFile(props, sta);
                break;
            case Constants.PD01:
                exe.executePDProcedureFile(props, sta);
                break;
            default:
                throw new RuntimeException("Please create impl for " + code + " code or chose some different code");
        }
    }

}
