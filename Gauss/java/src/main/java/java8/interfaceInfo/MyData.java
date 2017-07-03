package java8.interfaceInfo;

/**
 * Created by neerbans on 6/16/2017.
 */
public interface MyData {

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }

    default boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null || ("".equals(str));
    }
}
