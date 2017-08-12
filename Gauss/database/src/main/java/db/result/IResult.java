package db.result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by neerbans on 7/5/2017.
 */
public abstract class IResult {

    abstract public void showResultSet(ResultSet rs) throws SQLException;

     String getSpaces(int count) {
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<count; k++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
