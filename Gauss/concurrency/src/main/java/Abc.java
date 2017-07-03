import java.text.SimpleDateFormat;

/**
 * Created by neerbans on 6/9/2017.
 */
public class Abc {

    public static void main (String args[]) {

        ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<>();

        sdf.set(new SimpleDateFormat());

        System.out.println(sdf.get().toPattern());
    }
}
