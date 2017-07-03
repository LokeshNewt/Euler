package exception;

/**
 * Created by neerbans on 4/11/2017.
 */
public class DBException extends Exception {

    public DBException(String msg) {
        super(msg);
    }
    public DBException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
