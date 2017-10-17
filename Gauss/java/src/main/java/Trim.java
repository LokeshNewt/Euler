import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by neerbans on 2/18/2016.
 */
public class Trim {

    public static void main (String args[]) {
        Trim t = new Trim();
//        t.testBoolean("truee");
//        t.trimString();
       String s =  t.removeLeadingAndTrailingSpaces("/ jdjd/jdjdjd/   ab", "/");
        System.out.println(s);
    }

    private void dateTimeFormat() {

        String pattern = "MMM d, YYYY hh:MM:ss aa";
        Calendar cal = Calendar.getInstance();
        Date d = cal.getTime();
        System.out.println(d);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String s = simpleDateFormat.format(d);
        System.out.println(s);
    }

    private void testBoolean(String s) {
        Boolean b = new Boolean(s);
        System.out.println(b);
    }

    private void trimString() {
        String s = "select\n" +
                "        *\n" +
                "    from\n" +
                "        Visit visit0_ \n" +
                "    where\n" +
                "        visit0_.rowStatusCD = 'V' \n" +
                "        and (\n" +
                "            visit0_.PersonSid in (\n" +
                "                2016, 2018, 2008, 124, 2013, 2014, 2015\n" +
                "            )\n" +
                "        ) \n" +
                "        and visit0_.StatusDE<>764\n" +
                "        and (\n" +
                "            visit0_.TypeDE in (\n" +
                "                ?\n" +
                "            ) \n" +
                "            or coalesce(?, null) is null\n" +
                "        ) \n" +
                "        and (\n" +
                "            visit0_.AdmitDTTM>=? \n" +
                "            or ? is null\n" +
                "        ) \n" +
                "        and (\n" +
                "            visit0_.AdmitDTTM<=? \n" +
                "            or ? is null\n" +
                "        ) \n" +
                "    order by\n" +
                "        visit0_.AdmitDTTM asc";
        s = s.replaceAll("\n", "");
        s = s.trim().replaceAll(" +", " ");
        System.out.println(s);
    }

    private String removeLeadingAndTrailingSpaces(String s1, String divider) {
        if (s1.startsWith(divider)) {
            s1 = s1.substring(1);
        }
        if (s1.endsWith(divider)) {
            s1 = s1.substring(0, s1.length()-1);
        }
//        StringBuilder sb = new StringBuilder();
//        for (String s : s1.split(divider)) {
//            sb.append(s.trim());
//            sb.append(divider);
//        }
//        s1 = sb.toString();
//        return s1.substring(0, s1.length() - 1);
        return s1.trim();
    }

}
