package java8.interfaceInfo;


/**
 * Created by neerbans on 6/16/2017.
 */
public class MyDataImpl implements MyData{

    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null;
    }

    public static void main(String args[]){
        MyDataImpl obj = new MyDataImpl();
        obj.print("");
        obj.isNull("abc");
    }
}
