
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.stream.Collectors;

public class CrakingCoding {

    public static void main(String[] args) {
//        System.out.println(isUnique("str"));
//        System.out.println(isUnique("star"));
//        System.out.println(isUnique("staar"));
//        System.out.println(isUnique("azertyuiopqsdfghjklmwxcvbnn"));

//        System.out.println(checkPermutation("ab", "ba"));
//        System.out.println(checkPermutation("aa", "ba"));
//        System.out.println(checkPermutation("abb", "baa"));
//        System.out.println(checkPermutation("abc", "ab"));
//
//        System.out.println(URLify("Mr John Smith    ", 13));
//        System.out.println(URLify("Mr John Smith   ", 13));
//
//        System.out.println(palindromePermutation("Tact Coa", "taco cat"));
//
//        System.out.println(oneAway("pale", "ple"));
//        System.out.println(oneAway("pales", "pale"));
//        System.out.println(oneAway("pale","bake"));
//
//        System.out.println(stringCompression("aabccccaaaacAa"));
//        System.out.println(stringCompression("aaaaaaaaaa"));
//        System.out.println(stringCompression("aaaabcccaaa"));
//        System.out.println(stringCompression("abcccac"));
//        System.out.println(stringCompression("a"));
    }

    public static boolean isUnique(String str) {
        HashSet<Character> lettersList = new HashSet<>();
        if (str == null) return true;

        for (int i = 0; i < str.length(); i++) {
            lettersList.add(str.charAt(i));
        }
        return str.length() == lettersList.size();
    }

    public static boolean checkPermutation(String str1, String str2) {
        HashMap<Character, Integer> str1List = new HashMap<>();
        HashMap<Character, Integer> str2List = new HashMap<>();

        if(str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            str1List.putIfAbsent(str1.charAt(i), 0);
            str2List.putIfAbsent(str2.charAt(i), 0);
            str1List.put(str1.charAt(i), str1List.get(str1.charAt(i)) + 1 );
            str2List.put(str2.charAt(i), str2List.get(str2.charAt(i)) + 1 );
        }

        for (Character key: str1List.keySet()) {
            if (!str1List.get(key).equals(str2List.get(key))) return false;
        }
        return true;
    }

    public static String URLify(String str, int length) {
        int checkSize = (str.length() - length);
        int space = 0;

        Character[] characters = new Character[length];

        for (int i = 0; i < length; i++) {
            characters[i] = str.charAt(i);
            if(str.charAt(i) == ' ') {
                space++;
                checkSize++;
            }
        }
        if(checkSize - (space*3) >= 0) {
            str = Arrays.stream(characters).map(String::valueOf).collect(Collectors.joining());
            str = str.replace(" ", "%20");
        } else str = "Not enough place";

        return str;
    }

    public static boolean palindromePermutation(String str, String str2) {
        HashMap<Character, Integer> strList = new HashMap<>();
        HashMap<Character, Integer> str2List = new HashMap<>();

        str = str.toLowerCase();
        str2 = str2.toLowerCase();

        if(str.length() != str2.length()) return false;

        for (int i = 0; i < str.length(); i++) {
            strList.putIfAbsent(str.charAt(i), 0);
            str2List.putIfAbsent(str2.charAt(i), 0);
            strList.put(str.charAt(i), strList.get(str.charAt(i)) + 1 );
            str2List.put(str2.charAt(i), str2List.get(str2.charAt(i)) + 1 );
        }

        for (Character key: strList.keySet()) {
            if (!strList.get(key).equals(str2List.get(key))) return false;
        }
        return true;
    }

    public static boolean oneAway(String str, String str2) {
        int edit = 0;
        HashMap<Character, Integer> strList = new HashMap<>();
        HashMap<Character, Integer> str2List = new HashMap<>();

        for (int i = 0; i <str.length() ; i++) {
            strList.putIfAbsent(str.charAt(i), 0);
            if(strList.containsKey(str.charAt(i))) strList.put(str.charAt(i), strList.get(str.charAt(i)) + 1 );
        }

        for (int i = 0; i <str2.length() ; i++) {
            str2List.putIfAbsent(str2.charAt(i), 0);
            if(str2List.containsKey(str2.charAt(i))) str2List.put(str2.charAt(i), str2List.get(str2.charAt(i)) + 1 );
        }

        for (Character key: strList.keySet()) {
            if (!strList.get(key).equals(str2List.get(key))) edit++;
        }
        return edit <= 1;
    }

    public static String stringCompression(String str) {
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        if(str.length() == 1) return str;

        for (int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                counter++;
            } else {
                sb.append(str.charAt(i)).append(counter);
                counter = 1;
            }
            if(i + 1  == str.length() - 1) sb.append(str.charAt(i+1)).append(counter);
        }
        return sb.length() > str.length() ? str : sb.toString();
    }
}
