import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by neerbans on 2/5/2017.
 */
public class SirionLabs {

    public static void main (String args []) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);

        String numberString =  br.readLine();
        String [] numberStringArr = numberString != null ? numberString.split(" ") : new String[0];

        if (N == numberStringArr.length) {
            Arr arr[] = new Arr[N];
            int i = 0;
            for (String s : numberStringArr)
                arr[i++] = new Arr(s);

            Arrays.sort(arr);

            StringBuilder str = new StringBuilder();
            for (Arr o : arr) {
                str.append(o.number);
            }
             String s = str.toString().replaceFirst("0+(?!$)", "");
            System.out.println(s);
        }
    }
}

class Arr implements Comparable<Arr> {

    String number;

    public Arr(String number) {
        this.number = number;
    }

    @Override
    public int compareTo(Arr o) {
        String first = this.number + o.number;
        String second = o.number + this.number;
        return second.compareTo(first);
    }

}
