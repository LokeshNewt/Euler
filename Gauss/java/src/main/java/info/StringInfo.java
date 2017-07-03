package info;

/**
 * Created by neerbans on 4/7/2017.
 */
public class StringInfo {

    public static void main(String args[]) {

    }

    private void convertFirstLettertoUpperCase(String s) {
        s = Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }

    private void otherFunctions(String s) {
        s = s.toLowerCase();
        char c = s.charAt(0);
        Character c2 = s.charAt(0);
        int length = s.length();
    }

    private void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + 1 + "" + 1);
    }
}
