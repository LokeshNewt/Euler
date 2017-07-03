package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by neerbans on 10/8/2016.
 */
public class CommonUtil {

    public static Date parseDate(String d) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date;
        try {
            date = simpleDateFormat.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return date;
    }

    public static Date getCurrentServerDateTime() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        return date;
    }
}
