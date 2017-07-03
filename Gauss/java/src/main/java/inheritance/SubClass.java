package inheritance;

/**
 * Created by neerbans on 6/16/2017.
 */
public class SubClass extends SuperClass {

    public void displayResult() {

        System.out.println("Displaying from subClass");

        super.displayResult();
    }

    public static void main(String args[]) {

        SubClass obj = new SubClass();

        obj.displayResult();

    }
}
