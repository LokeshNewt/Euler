package util;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTimeZone;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by neerbans on 8/22/2017.
 */
public class DateUtil {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String[] DATE_FORMATS = { YYYY_MM_DD, YYYY_MM_DD_HH_MM_SS };
    private DateUtil(){
    }

    public static Date parseDateWithoutTime(String dateInString) throws ParseException {
        Date date = null;
        if (StringUtils.isNotBlank(dateInString)) {
            date = removeTimeStamp(parseDate(dateInString));
        }
        return date;
    }

    public static Date parseDate(String str) throws ParseException {
        String[] parsePatterns = DATE_FORMATS;
        if (StringUtils.isNotBlank(str) && parsePatterns != null) {
            SimpleDateFormat parser = null;
            ParsePosition pos = new ParsePosition(0);

            for (int i = 0; i < parsePatterns.length; ++i) {
                if (i == 0) {
                    parser = new SimpleDateFormat(parsePatterns[0]);
                    parser.setLenient(false);
                } else {
                    parser.applyPattern(parsePatterns[i]);
                }

                pos.setIndex(0);
                Date date = parser.parse(str, pos);
                if (date != null && pos.getIndex() == str.length()) {
                    return date;
                }
            }
            throw new ParseException("Unable to parse the date: " + str, -1);
        }
        return null;
    }

    public static Date getCurrentDateInUTC() {
        Date date = new Date();
        DateTimeZone zone = DateTimeZone.getDefault();
        long utc = zone.convertLocalToUTC(date.getTime(), false);
        return new Date(utc);
    }

    public static Date applyUTCTimeZone(Date date) {
        DateTimeZone zone = DateTimeZone.getDefault();
        long utc = zone.convertLocalToUTC(date.getTime(), false);
        return new Date(utc);
    }

    public static Date getCurrentDateWithoutTime() {
        Date date = new Date();
        return removeTimeStamp(date);
    }

    private static Date removeTimeStamp(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date applyLocalTimeZone(Date date) {
        if (date != null) {
            DateTimeZone zone = DateTimeZone.getDefault();
            long local = zone.convertUTCToLocal(date.getTime());
            return new Date(local);
        }
        return null;
    }

    public static Date applyDummyTimeZone(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 11);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
}

