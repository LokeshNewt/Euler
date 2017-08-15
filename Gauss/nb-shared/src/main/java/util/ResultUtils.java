package util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by neerbans on 12/8/17.
 */
public class ResultUtils {

    public static void result(Object response) {
//        Gson gson = new GsonBuilder().registerTypeAdapter(CustomDate.class, new CustomDateSerializer()).setPrettyPrinting().create();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String res = gson.toJson(response);
        System.out.println(res);
    }
}
