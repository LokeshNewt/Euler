package exception_handling;

/**
 * Created by neerbans on 6/19/2017.
 */
public class ExceptionHandling {

    public static void main(String args[]) {
        int sum = 0;
        try {
            int i;
            sum = 10;
            for (i = -1; i < 3 ;++i)
                sum = (sum / i);
        }
        catch(ArithmeticException e) {
            System.out.print("0");
        }
        System.out.print(sum);
    }
}
