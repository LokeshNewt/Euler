import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by neerbans on 9/9/2015.
 */
public class ArrangeFile {
    public static void main(String args[]) throws IOException {

        String path = "C:\\Neeraj\\Files\\dict.txt";
        ArrangeFile a = new ArrangeFile();
        a.arrangeFile(path);

    }

    void arrangeFile(String path) throws IOException {

        System.out.println(path);
        String line;
        List<String> z = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        //val bufferedSource = Source.fromFile(path, "iso-8859-1");
        while ((line = br.readLine()) != null) {
            z.add(line);
        }
        br.close();

        Collections.sort(z);

        PrintWriter writer= new PrintWriter(path);
        writer.close();

        PrintWriter writer2= new PrintWriter(path);
        for (int i=0; i<z.size(); i++) {
            writer2.write(z.get(i));
            writer2.write("\r\n");
        }
        writer2.close();
    }
}
