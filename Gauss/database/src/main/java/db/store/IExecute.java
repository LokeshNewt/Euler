package db.store;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by neerbans on 7/5/2017.
 */
public interface IExecute extends IDBStore{

    void executeFile (Properties props, Statement sta) throws SQLException;

    void executePDProcedureFile (Properties props, Statement sta);

    default String getProcedureName(String s) {
        int l = s.indexOf("(");
        if (l == -1) {
            l = s.indexOf("AS");
        }
        return s.substring(s.indexOf("get"), l-1);
    }
}
