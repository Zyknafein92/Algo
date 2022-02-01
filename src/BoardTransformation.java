import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class BoardTransformation {

    // utilises split
    // map (stream)
    // algo l'inverse de string


    public static void main(String[] args) {
        String[] inits = new String[] {"aaabbbcc1", "xxookkkk", "changer", "métro", "paris", "banlieure"};
        String[] result = new String[inits.length];
        // transformer vers tableau avec les string inversé
        // 1. sans stream
        for (int i = 0; i < inits.length; i++) {
            result[i] = reverseString(inits[i]);
            //result[i] = reverseStringJava8(inits[i]);
        }
        System.out.println("Sans Java8" + Arrays.toString(result));
        // 2. avec stream
        List<String> collect = Arrays.stream(inits).map(element -> reverseStringJava8(element)).collect(Collectors.toList());
        String[] strings = collect.toArray(new String[collect.size()]);
        System.out.println("Avec Java8" + Arrays.toString(strings));
    }

    private static String reverseStringJava8(String s) {
        List<String> l = Arrays.stream(s.split("")).collect(Collectors.toList());
        Collections.reverse(l);
        return l.stream().collect(Collectors.joining());
    }

    private static String reverseString(String s) {
        String result = "";
        String[] v = s.split("");
        for (int i = s.length() - 1; i >= 0 ; i--) {
            result += v[i];
        }
        return result;
    }
}
