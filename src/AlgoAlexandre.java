import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;


public class AlgoAlexandre {

    public static void main(String[] args) {
//        System.out.println(reshape(3, "abc de fghij"));
//        System.out.println(reshape(2, "1 23 456"));
//        System.out.println(reshape(5, "a")); //todo : a faire
//        System.out.println(reshape(1, null));
//        System.out.println(reshape(5,"abcde"));
//        System.out.println(reshape(2147483647, "une longue string asdkjasdlkajsdklasjdkasjkldkjaskldasjkaskjldjaslkdjaskldjaskdasjdlhdafjhgdiufhipvzdvbobvv"));
//        System.out.println(reshape(25, "Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression." +
//                " Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un imprimeur anonyme assembla ensemble des morceaux" +
//                " de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, " +
//                "mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié." +
//                " Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, " +
//                "et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker."));
//        System.out.println(encode("aabaa"));
//        System.out.println(encode("aaaabcccaaa"));
//        System.out.println(encode("abcccac"));
//        System.out.println("a");
//        System.out.println(echo("Hello you !"));
//        System.out.println(echo(null));
        //       System.out.println(countTriplets(Arrays.asList(1L, 2L, 2L, 4L),2));
        // System.out.println(countTriplets(Arrays.asList(1L,3L,9L, 9L,27L,81L),3));
//        int arr[] = new int[100];
//        for (int i = 0; i < 100; i++) {
//            arr[i] = 100;
//        }
//        System.out.println(countTriplets(arr,1));
        //  System.out.println(extraLongFactorials(25));
        // System.out.println(Arrays.asList(Arrays.asList(5,3,4), Arrays.asList(1,5,8), Arrays.asList(6,4,2)));
//        System.out.println(anagram("abc","cba"));
//        System.out.println(anagram("abc", "dpo"));
//        System.out.println(anagram("abc", "cbac"));

//        System.out.println(checkMagazine("give me one grand today night", "give one grand today"));
    }
//
//    public static String reshape(int n, String str) {
//        if(str == null ) {
//            return null;
//        }
//        str = str.replace(" ", "");
//        List<String> stringList = Arrays.asList(str.split(""));
//        stringList = new ArrayList<>(stringList);
//        String result = String.join("", stringList);
//        List<String> resultList = new ArrayList<>();
//        int counter = 0;
//        while (n + counter <= result.length()) {
//            resultList.add(result.substring(counter, n + counter));
//            if(result.length() % n != 0 && counter + n + 1 == result.length())  {
//                resultList.add(result.substring(counter+n));
//            }
//            counter += n;
//        }
//        StringBuilder sb = new StringBuilder();
//        resultList.forEach(r -> sb.append(r).append("\n"));
//        str = sb.toString();
//        return str;
//    }
//
//    public static String encode(String str) {
//        if (str == null) {
//            return null;
//        }
//        String[] letter = str.split("");
//        int counter = 1;
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < letter.length - 1; i++) {
//            if (letter[i].equals(letter[i + 1])) {
//                counter++;
//            }
//            else {
//                result.append(letter[i]).append(counter);
//                counter = 1;
//            }
//            if (i+1 == letter.length -1) { //todo : revoir cette partie
//                result.append(letter[i+1]).append(counter);
//            }
//        }
//        return result.toString();
//    }
//
//    public static String echo(String str) {
//        if(str == null) return null;
//        str = str.replace(" ", "\n");
//        return str;
//    }
//
//
//    public  static long countTriplets(int[] arr, int r) {
////        long count = 0L;
////        int i = 0;
////        Map<Long,Integer> listNumbers = new HashMap<>();
////
////        for (Long number: arr) {
////            listNumbers.putIfAbsent(number,0);
////            listNumbers.put(number,listNumbers.get(number)+1);
////        }
////
////        for(Map.Entry<Long,Integer> value: listNumbers.entrySet()) {
////            if (listNumbers.get((value.getKey() *  r)) != null && listNumbers.get((value.getKey() * r * r)) != null) {
////                int v = Math.max(listNumbers.get(value.getKey()), listNumbers.get(value.getKey() * r));
////                System.out.println(listNumbers.get((value.getKey() *  r)) + " " + listNumbers.get((value.getKey() * r * r)));
////                v = Math.max(v, listNumbers.get(value.getKey() * r * r));
////                System.out.println(v);
////                count+= v;
////            }
////        }
////       System.out.println(count);
////        return count;
//
//        Map<Integer, List<Integer>> numberToIndices = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (!numberToIndices.containsKey(arr[i])) {
//                numberToIndices.put(arr[i], new ArrayList<>());
//            }
//
//            numberToIndices.get(arr[i]).add(i);
//        }
//
//        long result = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] % r != 0) {
//                continue;
//            }
//
//            int firstNumber = arr[i] / r;
//
//            if ((long) arr[i] * r > Integer.MAX_VALUE) {
//                continue;
//            }
//
//            int lastNumber = arr[i] * r;
//
//            result += (long) findBeforeCount(numberToIndices, firstNumber, i)
//                    * findAfterCount(numberToIndices, lastNumber, i);
//        }
//        return result;
//    }
//
//
//    static int findBeforeCount(Map<Integer, List<Integer>> numberToIndices, int number, int index) {
//        if (!numberToIndices.containsKey(number)) {
//            return 0;
//        }
//
//        List<Integer> indices = numberToIndices.get(number);
//        int position = Collections.binarySearch(indices, index);
//        if (position < 0) {
//            position = -1 - position;
//        }
//
//        return position;
//    }
//
//    static int findAfterCount(Map<Integer, List<Integer>> numberToIndices, int number, int index) {
//        if (!numberToIndices.containsKey(number)) {
//            return 0;
//        }
//
//        List<Integer> indices = numberToIndices.get(number);
//        int position = Collections.binarySearch(indices, index);
//        if (position < 0) {
//            position = -1 - position - 1;
//        }
//
//        return indices.size() - 1 - position;
//    }
//
//    static void plusMinus(List<Integer> arr) {
//        double positif = 0;
//        double negatif = 0;
//        double zero = 0;
//
//
//        for (Integer value : arr) {
//            if (value > 0) {
//                positif++;
//            } else if (value < 0) {
//                negatif++;
//            } else {
//                zero++;
//            }
//        }
//        DecimalFormat df = new DecimalFormat("0.000000");
//        System.out.println(df.format(positif / arr.size()));
//        System.out.println(df.format(negatif / arr.size()));
//        System.out.println(df.format(zero / arr.size()));
//    }
//
//    public static BigDecimal extraLongFactorials(int n) {
//        BigDecimal value = BigDecimal.valueOf(n);
//
//        while (n > 1 && n < 100) {
//            n--;
//            value = value.multiply(BigDecimal.valueOf(n));
//        }
//        return value;
//    }
//
//    public static int formingMagicSquare(List<List<Integer>> s) {
//        // System.out.println(Arrays.asList(Arrays.asList(5,3,4), Arrays.asList(1,5,8), Arrays.asList(6,4,2)));
//        List<List<Integer>> verticaleValue = new ArrayList<>();
//
//        for (int i = 0; i < s.size(); i++) {
//            for (int j = 0; j < s.get(i).size(); j++) {
//
//            }
//        }
//        return 0;
//    }
    // abc - cba
//    public static boolean anagram(String a, String b) {
//        // a/b/c -> []  - c/b/a -> []
//        Character[] aChar = new Character[a.length()];
//        Character[] bChar = new Character[b.length()];
//
//        for (int i = 0; i < a.length(); i++) {
//            aChar[i] = a.charAt(i);
//        }
//        for (int i = 0; i < b.length(); i++) {
//            bChar[i] = b.charAt(i);
//        }
//
//        Arrays.sort(aChar);
//        Arrays.sort(bChar);
//
//        return Arrays.equals(aChar, bChar);
//    }

//    public static void checkMagazine(List<String> magazine, List<String> note) {
//        // Write your code here
//        HashMap<String,Integer> noteList = new HashMap<>();
//        HashMap<String,Integer> magazineList = new HashMap<>();
//
//        for(String n : note) {
//            if(noteList.get(n) != null) noteList.put(n,noteList.get(n)+1);
//            noteList.putIfAbsent(n, 0);
//        }
//
//        for(String m: magazine) {
//            if(noteList.get(m) != null) {
//                if (magazineList.get(m) != null && noteList.get(m) > 2) magazineList.put(m, magazineList.get(m) + 1);
//                magazineList.putIfAbsent(m, 0);
//            }
//        }
//
//        if(noteList.equals(magazineList)) System.out.println("Yes");
//        System.out.println("No");
//
//
//
//    }
//
//    public static int activityNotifications(List<Integer> expenditure, int d) {
//        // Write your code here
//        int[] arrayExp = expenditure.stream().mapToInt(Integer::intValue).toArray();
//        double   median = 0;
//
//        if(d % 2 == 0) {
//            int m1 = 0;
//            int m2 = 0;
//
//            for(int i = 0; i < arrayExp.length; i++) {
//
//            }
//
//        } else {
//
//        }
//
    }

