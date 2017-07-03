package info;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by neerbans on 3/30/2017.
 */
public class ListInfo {

    public static void main(String [] args) {
        ListInfo l = new ListInfo();
        l.initializeList();
    }

    private void arrayList() {
        ArrayList arrayList = new ArrayList();
    }

    private void initializeList() {
        List<String> list = Arrays.asList("", "");
    }

    private void sortList(List<String> list) {
        Collections.sort(list);
    }

    private void iterateList(List<String> list) {
        list.forEach(System.out::println);
        list.forEach(this::testMethod);
    }

    private void testMethod(String a) {
        System.out.println(a);
    }

    // reading a file
    private void readFile(String fileName) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
    }
}
