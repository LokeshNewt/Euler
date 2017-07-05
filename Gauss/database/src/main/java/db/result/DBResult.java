package db.result;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by neerbans on 5/3/2017.
 */
public class DBResult extends IResult{

    private static Logger logger = Logger.getLogger(DBResult.class);

    private static final int SPACE_COUNT = 30;
    private static final int MAX_COLUMN_LENGTH = 28;

    public void showResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        for (int j = 1; j <= columnCount; j++) {
            int length = resultSetMetaData.getColumnName(j).length();
            System.out.print(resultSetMetaData.getColumnName(j) + getSpaces(SPACE_COUNT-length));
        }
        System.out.println();
        while (rs.next()) {
            for (int i=1; i<=columnCount; i++) {
                int length = 4;
                String s = null;
                if (rs.getObject(i) != null) {
                    s = rs.getObject(i).toString();
                    if (s.length() > MAX_COLUMN_LENGTH)
                        s = s.substring(0, MAX_COLUMN_LENGTH);
                    length = s.length();
                }
                System.out.print(s + getSpaces(SPACE_COUNT-length));
            }
            System.out.println();
        }
//        http://stackoverflow.com/questions/20545817/resultset-get-all-values
    }

}
