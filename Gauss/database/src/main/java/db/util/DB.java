package db.util;

/**
 * Created by neerbans on 6/20/2017.
 */
public enum  DB {

    oracle("ORACLE"), sql("SQL"), mysql("MYSQL"), h2("H2"), postgre("POSTGRE");

    DB(String db) {
    }

//    @Override
//    public String toString() {
//        String s = "";
//        for (DB db : DB.values()) {
//            s = s + db.toString() + " ";
//        }
//        return s;
//    }
}
