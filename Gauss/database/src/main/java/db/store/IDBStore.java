package db.store;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by neerbans on 7/5/2017.
 */
public interface IDBStore {

    void getDBTableInfo(Statement sta, String code, String dbType) throws SQLException;

    void getAllRecords(Statement sta, String tableName) throws SQLException;
}
