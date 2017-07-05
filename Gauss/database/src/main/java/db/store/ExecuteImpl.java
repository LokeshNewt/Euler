package db.store;

import db.result.IResult;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Properties;

/**
 * Created by neerbans on 7/5/2017.
 */
public class ExecuteImpl implements IExecute {

    private static Logger logger = Logger.getLogger(ExecuteImpl.class);

    private IResult result;

    public ExecuteImpl (IResult result) {
        this.result = result;
    }

    @Override
    public void executeFile(Properties props, Statement sta) throws SQLException {
        try {
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
                        result.showResultSet(rs);
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

    @Override
    public void executePDProcedureFile(Properties props, Statement sta) {
        try {
            InputStream inputStream = ClassLoader.getSystemResourceAsStream("script/pd-procedure.sql");
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
                    String procedureName = getProcedureName(stat);
                    logger.info("Creating procedure : " + procedureName);
                    logger.info("Executing statement :" + stat);
                    try {
                        sta.execute(stat);
                    } catch (SQLException e) {
                        if (e.toString().contains("There is already an object named")) {
                            logger.info("Procedure " + procedureName + " already exist");
                        } else {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDBTableInfo(Statement sta, String code, String dbType) throws SQLException {
        Map<String, String> queryMap = DBQueries.queryMap;
        String sql = queryMap.get(dbType + "" + code);
        ResultSet rs = sta.executeQuery(sql);
        System.out.println("Here is the list :");
        result.showResultSet(rs);
    }

    public void getAllRecords(Statement sta, String tableName) throws SQLException {
        String sql = "select * from " + tableName;
        logger.info("Executing statement : " + sql );
        ResultSet rs = sta.executeQuery(sql);
        result.showResultSet(rs);
    }
}
