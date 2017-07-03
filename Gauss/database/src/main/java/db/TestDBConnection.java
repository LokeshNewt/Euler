package db;

import java.sql.*;
import java.util.Properties;

/**
 * Created by neerbans on 5/8/2015.
 */
public class TestDBConnection {

    public static void main(String args[]) throws ClassNotFoundException, SQLException {

        TestDBConnection m35 = new TestDBConnection();
//        m35.connectMysql();

    }



    public void connectOracle() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "system", "Edifecs2014");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "neerbans", "Neeraj123");
            //conn = DriverManager.getConnection("jdbc:sqlserver://10.30.24.110;user=sa;password=Edifecs2014;database=addy");
//            conn = DriverManager.getConnection("jdbc:sqlserver://10.64.54.76;user=sa;password=Edifecs2014;database=xcdr");
            System.out.println("test");
            Statement sta = conn.createStatement();
            String Sql = "select * from DEMO_CUSTOMERS";
            ResultSet rs = sta.executeQuery(Sql);
            while (rs.next()) {
                System.out.println(rs.getString("CUST_FIRST_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectVertica() {
        try {

            Class.forName("com.vertica.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            // Could not find the driver class. Likely an issue

            // with finding the .jar file.

            System.err.println("Could not find the JDBC driver class.");

            e.printStackTrace();

            return; // Bail out. We cannot do anything further.

        }
        Properties myProp = new Properties();

        myProp.put("user", "dbadmin");

        myProp.put("password", "1q2w3e4r5t");

        Connection conn;

        try {

            conn = DriverManager.getConnection(

                    "jdbc:vertica://10.20.20.113:5433/ppm", myProp);

            Statement stmt = conn.createStatement();
            //String sql = "Select * from fact.ClaimService";
            String sql = "Select count(*) as rowcount from  fact.ClaimHeader";
            ResultSet rs = stmt.executeQuery(sql);

            rs.next();
            int i = rs.getInt("rowcount");
            rs.close();
//            while(rs.next()) {
//                ++i;
////                System.out.println(rs.getInt("auditID"));
////                System.out.println(rs.getString("entityStatus"));
//            }
            System.out.println(i);

        } catch (SQLException e) {

            // Could not connect to database.

            System.err.println("Could not connect to database.");

            e.printStackTrace();

            return;

        }

    }

    private String getScript() {
        return "create table EmpAddress (\n" +
                "   addressId bigint primary key auto_increment,\n" +
                "   empId bigint not null,\n" +
                "   street varchar(50),\n" +
                "   city varchar(50),\n" +
                "   state varchar(50),\n" +
                "   country varchar(50),\n" +
                "   createdDate varchar(50)\n" +
                " )";
    }
}







