package util;

import org.apache.commons.codec.binary.StringUtils;

/**
 * Created by neerbans on 9/28/2017.
 */
public class Common {

    public static void main (String args[]) {

        Common c = new Common();
        System.out.println(c.removeLeadingAndTrailingSpaces("hello world", "/"));

    }

    private String removeLeadingAndTrailingSpaces(String s1, String divider) {
        if (s1.startsWith(divider)) {
            s1 = s1.substring(1);
        }
        if (s1.endsWith(divider)) {
            s1 = s1.substring(0, s1.length()-1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : s1.split(divider)) {
            sb.append(s.trim());
            sb.append(divider);
        }
        s1 = sb.toString();
        return s1.substring(0, s1.length()-1);
    }
}
