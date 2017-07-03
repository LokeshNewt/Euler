package db;

import db.util.Constants;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by neerbans on 5/3/2017.
 */
public class DBConnection {

    private static Logger logger = Logger.getLogger(DBConnection.class);

    private Properties props = null;

    public DBConnection(Properties props) {
        this.props = props;
    }

    protected Connection getDBConnection(String db) {
        try {
            String url = props.getProperty(db + "." + Constants.URL);
            Class.forName(props.getProperty(db + "." + Constants.DRIVER));
            String user = props.getProperty(db + "." + Constants.USERNAME);
            String password = props.getProperty(db + "." + Constants.PASSWORD);
            Connection conn = DriverManager.getConnection(url, user, password);
            logger.info("Database connection established with user : " + user);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
