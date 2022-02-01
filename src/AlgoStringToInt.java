import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AlgoStringToInt {

    // "Jerome", "est", "en", "train", "de", "chercher", "un", "stage"
    // 6, 3, 2, ...

    public static void main(String[] args) {
        String[] s = new String[]{"Jerome", "est", "en", "train", "de", "chercher", "un", "stage"};
        // utilises .map() de java 8
      System.out.println("Ordre : " + Arrays.toString(stringToInt(s)) + " | " + " Désordre : " + Arrays.toString(reverseStringToInt(s)));
      System.out.println("Ordre Java 8: " + Arrays.toString(stringToIntJava8(s)) + " | " + " Désordre Java 8 : " + Arrays.toString(reverseStringToIntJava8(s)));;
    }

    public static int[] stringToInt(String[] s) {
        int[] r = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            r[i] = s[i].length();
        }
        return r;
    }

    public static int[] reverseStringToInt(String[] s) {
        int[] r = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            r[i] = s[s.length - i - 1].length();
        }
        return r;
    }

    public static int[] stringToIntJava8(String[] s) {
        return Arrays.stream(s).mapToInt(String::length).toArray();
    }

    public static int[] reverseStringToIntJava8(String[] s) {
        List<String> stringList = Arrays.asList(s);
        Collections.reverse(stringList);
        return Arrays.stream(s).mapToInt(String::length).toArray();
    }
}
