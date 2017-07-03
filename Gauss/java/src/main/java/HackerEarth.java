import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by neerbans on 2/6/2017.
 */

//class Node {
//    int val;
//    Node next;
//    Node back;
//    public Node(int a) {
//        this.val = a;
//        this.next = null;
//        this.back = null;
//    }
//}

public class HackerEarth {
    public static int a ;
    public static void main(String args []) {
        try {
            int b = 2;
            HackerEarth hackerEarth = new HackerEarth();
            hackerEarth.learnJava8();
//            List<List<Integer>> b = new ArrayList<>();
//            List<Integer> c = new ArrayList<>();
//            c.add(7);
//            c.add(3);
//            List<Integer> c2 = new ArrayList<>();
//            c2.add(5);
//            c2.add(2);
//            b.add(c);b.add(c2);
////            c.add(5);
////            c.add(9);
////            c.add(7);
////            c.add(6);
////            c.add(2);
//            hackerEarth.rotateMatrxi(b);

            //Stack a = new Stack();
            //a.push()
//            String a = null;
//            String b = "xyz";
//            String c = a+b;
//            System.out.println("c" + c);
            String trued = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    static {
//        System.out.println("static block");
//    }
    private void truee(int add) {
        add = a;
    }

    private void learnJava8 () {
        List<String> names1 = new ArrayList<>();
        names1.add("Mahesh ");
        names1.add("Suresh ");
        names1.add("Ramesh ");
        names1.add("Naresh ");
        names1.add("Kalpesh ");
        List<String> names2 = new ArrayList<String>();
        names2.add("Mahesh ");
        names2.add("Suresh ");
        names2.add("Ramesh ");
        names2.add("Naresh ");
        names2.add("Kalpesh ");

        Collections.sort(names1, (s1, s2) -> s1.compareTo(s2)); // lambda expression to sort

        names1.forEach(System.out::println); // for each loop and method refrences

        MathOperation addition = (c, d) -> c + d; // inline implementation of a functional interfaceInfo

        Greeting greeting = message -> System.out.println("Hello " + message); // inline implementation of a functional interfaceInfo

        System.out.println(operate(5, 10, addition));
        greeting.sayMessage("neeraj");

        eval(names1, s -> s.contains("re"));  // functional interfaceInfo in Java 8

        //streams - collection interfaces generate streams, other stream methods - limit, sorted, count
        List<String> filtered = names1.stream().filter(s -> s.contains("re")).collect(Collectors.toList());
        System.out.println(filtered);
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5, 6, 7, 5, 4);
        List<Integer> squareList = numbers.stream().map(n -> n * n).distinct().collect(Collectors.toList());
        System.out.println(squareList);
        // collectors
        String s2 = names1.stream().filter(s -> s.contains("re")).collect(Collectors.joining(", "));
        System.out.println(s2);

        // Optional
        Integer value1 = null;
        Integer value2 = 10;

        Optional<Integer> a = Optional.ofNullable(value1); // allows passed parameter to be null
        Optional<Integer> b = Optional.of(value2); // throws exception if passed parameter is null
        System.out.println(a.isPresent() + " - " + b.isPresent());
        System.out.println(a.orElse(5)); // returns value if present otherwise returns default value
        System.out.println(b.get()); // gets the value, value should be present

        // timezone api's
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println(date1);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println(currentZone);

        LocalTime time1 = LocalTime.now();
        Duration duration = Duration.ofHours(2);
        time1 = time1.plus(duration);
        System.out.println(time1);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface Greeting {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation operation) {
        return operation.operation(a, b);
    }

    private void defineArrays () {
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 7);
    }

    private static void eval(List<String> list, Predicate<String> predicate) {
        for (String s : list) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }
    }

    private int quickSort (int [] arr, int start, int end) {
        //int a = 4;
        int pivot = arr[end];

        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }

    private void swap(int [] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private void braces(String a) {
//        Stack<Integer> s = new Stack<>();
//        for (int i=0; i<s.size(); i++) {
//            char c = a.charAt(i);
//            if (c == 40 || c == 91 || c == )
//        }
    }

    private void rotateMatrxi(List<List<Integer>> a) {
        int size = a.size();
        int number = a.size()-1;
        for (int i = 0; i< size/2; i++) {
            for (int j = i; j< number; j++) {
                int p = i;
                int q = j;
                int row = p;
                int column = q;
                List<Integer> list = a.get(p);
                int val = list.get(q);
                do {

                    int temp = p;
                    p = q;
                    q = size - 1 - temp;

                    List<Integer> list2 = a.get(p);
                    int temp_val = list2.get(q);
                    list2.set(q, val);
                    val = temp_val;

                } while (p != row || q != column);
            }
            number = number - 1;
        }
        System.out.println(a);
    }

//    private void nextPermutation(List<Integer> a) {
//        boolean flag = false;
//        for (int i = a.size()-1; i>0 ; i--) {
//            if ((a.get(i-1)+"").compareTo(a.get(i)+"") < 0) {
//                int p = a.get(i-1);
//                List<Integer> b1 = a.subList(0, i-1);
//                List<Integer> b2 = a.subList(i-1, a.size());
//
//                Collections.sort(b2, new HackerEarth());
//
//                int b = b2.lastIndexOf(p);
//                int q = b2.get(b+1);
//                b1.add(q);
//                //b2.remove(b+1);
//                b1.addAll(b2);
//                System.out.println(b1);
//                flag = true;
//                break;
//            }
//        }
//        if (!flag) {
//            Collections.sort(a, new HackerEarth());
//            System.out.println(a);
//        }
//    }

//    private void deleteFriends() throws IOException {
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        Integer N = Integer.parseInt(line);
//        for (int i=0; i<N; i++) {
//            String line1 = br.readLine();
//            String line2 = br.readLine();
//            String arr1[] = line1.split(" ");
//            int number = Integer.parseInt(arr1[0]);
//            int m = Integer.parseInt(arr1[1]);
//
//            String arr2[] = line2.split(" ");
//            Node start = new Node(Integer.parseInt(arr2[0]));
//            Node prevNode = start, newNode;
//            for (int j=1; j<number; j++) {
//                int val = Integer.parseInt(arr2[j]);
//                newNode = new Node(val);
//                newNode.back = prevNode;
//                prevNode.next = newNode;
//                prevNode = newNode;
//            }
//
//            int count = 0;
//            Node back = null;
//            Node current = start;
//            while (current.next != null && count < m) {
//                Node next = current.next;
//                if (current.val < next.val) {
//                    if (back != null) {
//                        back.next = next;
//                        next.back = back;
//                        current = back;
//                        back = back.back;
//                    } else {
//                        next.back = null;
//                        start = next;
//                        current = next;
//                    }
//                    ++count;
//                } else {
//                    back = current;
//                    current = next;
//                }
//            }
//
//            Node node = start;
//            int c = 0;
//            while (node != null && c < (number - m)) {
//                System.out.print(node.val + " ");
//                node = node.next;
//                ++c;
//            }
//            System.out.println();
//        }
//    }



    private void demandTrailByCombat() throws IOException {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int i = 0;
        for (i=0; i<N; i++) {
            String line1 = br.readLine();
            String line2 = br.readLine();
            String arr1[] = line1.split(" ");
            int number = Integer.parseInt(arr1[0]);
            int m = Integer.parseInt(arr1[1]);

            StringBuilder sb = new StringBuilder();
            String lineZero = "";
            for (int r=0; r<number-1; r++) {
                sb.append("0 ");
            }
            sb.append("0");
            lineZero = sb.toString();

            boolean resultFlag = false;
            boolean greater = (m > number);

            int index = line2.indexOf("0");
            if (index == -1) {
                resultFlag = true;
            } else {
                for (int r=index+2; r<(2*number-1); r=r+4) {
                    if (line2.charAt(r) == '0') {
                        if (m > number) {
                            System.out.println("dddd");
                            line2 = lineZero;
                            resultFlag = true;
                        }
                        break;
                    }
                }

            }

            String arr2[] = new String[number];
            if (!resultFlag) {
                for (int j=0; j<m ; j++) {
                    arr2 = line2.split(" ");
                    if (!line2.contains("0") || !line2.contains("1")) {
                        break;
                    }
                    else if (line2.contains("0 0") && m > number) {
                        System.out.println("dddd2");
                        line2 = lineZero;
                        break;
                    }
                    line2 = "";
                    for (int k=0; k<number ; k++) {
                        if (k == 0) {
                            // sb.append(arr2[k+1] + " ");
                            line2 += arr2[k+1] + " ";
                        } else if (k == number-1) {
                            // sb.append(arr2[k-1]);
                            line2 += arr2[k-1];
                        } else if (Integer.parseInt(arr2[k-1]) == 1 &&
                                Integer.parseInt(arr2[k+1])==1) {
                            // sb.append("1 ");
                            line2 += "1 ";
                        } else {
                            // sb.append("0 ");
                            line2 += "0 ";
                        }
                    }
                }
            }

            System.out.println(line2);
            // StringBuilder sb = new StringBuilder();
            // for (String s5 : arr2) {
            //     sb.append
            // }
        }
    }

}
