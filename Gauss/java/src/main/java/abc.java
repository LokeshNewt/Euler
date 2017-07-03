import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neerbans on 2/5/2017.
 */
public class abc {

    public static void main (String args[]) {
        List<String> inputByLine = new ArrayList<String>();
        try {
            // Get the object of DataInputStream
            InputStreamReader isr = new InputStreamReader(System.in,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
//            while ((line = br.readLine()) != null){
//                inputByLine.add(line);
//            }
            inputByLine.add(br.readLine());
            StringBuilder sb;
            for (String line2 : inputByLine) {
                Integer a = Integer.parseInt(line2);
                int m;
                if (a%2 == 0)
                    m = a/2;
                else m = a/2 + 1;
                for (int i = 1; i<=a ; i++) {
                    sb = new StringBuilder();
                    int z = i;
                    if (i > m)
                        z = a - i + 1;
                    for (int j = 1; j<=a ; j++) {
                       if (j<=z)
                           sb.append("*");
                       else sb.append("#");
                    }
                    if (i % 2 == 0)
                        sb = sb.reverse();
                    System.out.println(sb.toString());
                }
            }

            isr.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
