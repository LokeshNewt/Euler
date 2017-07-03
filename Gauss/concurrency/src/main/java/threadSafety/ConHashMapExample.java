package threadSafety;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by neerbans on 6/5/2017.
 */
public class ConHashMapExample {

    public static void main (String args[]) {

        ConHashMapExample e = new ConHashMapExample();
//        e.ConcurrentHashMap();
        e.SimpleHashMap();
    }

    private void ConcurrentHashMap() {
        Map<String, String> m = new ConcurrentHashMap<>();
        m.put("1", "1");
        m.put("2", "2");

        System.out.println("Before iterator: " + m);

        for (String key : m.keySet()) {
            if (key.equals("1")) {
                m.put(key + "new", "new1");
            }
        }

        System.out.println("After iterator: " + m);
    }

    private void SimpleHashMap() {
        Map<String, String> m = new HashMap<>();
        m.put("1", "1");
        m.put("2", "2");

        System.out.println("Before iterator: " + m);

        for (String key : m.keySet()) {
            if (key.equals("1")) {
                m.put(key, "new1");
            }
        }

        System.out.println("After iterator: " + m);
    }
}
