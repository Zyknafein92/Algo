import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;



public class AlgorAlexandreII {

    public static void main(String[] args) {

//        System.out.println(computeCheckDigit("39847"));
//        System.out.println(computeCheckDigit("34"));
//        System.out.println(computeCheckDigit("343428"));
//        System.out.println(booleanA(1,5));
//        System.out.println(booleanA(2,3));
//        System.out.println(booleanA(-3,4));
        System.out.println(duodigit(12));
        System.out.println(duodigit(2020));
        System.out.println(duodigit(-2021));
        System.out.println(duodigit(-222));
        System.out.println(duodigit(756));
    }

    private static int computeCheckDigit(String s) {
        Integer sumWithoutImpair = 0;
        Integer impairList = 0;

        if(s.length() > 0 && s.length() < 13) {
            String[] stringList = s.split("");

            for (int i = 0; i < stringList.length; i++) {
                if (i % 2 == 0) {
                    sumWithoutImpair += Integer.parseInt(stringList[i]);
                } else {
                    impairList += Integer.parseInt(stringList[i]);
                }
            }
            sumWithoutImpair *= 3;
            Integer result = sumWithoutImpair + impairList;
            return 10 - result % 10 == 10  ?  0 : 10 - result % 10;
        } else return 0;
    }

    private static boolean booleanA(int i, int j) {
        return i == 1 || j == 1 || i + j == 1;
    }

    private static int duodigit(int number) {
        String[] numberToTest = String.valueOf(number).split("");
        return new HashSet<>(Arrays.asList(numberToTest)).size() == 2 ? 0 : 1;
    }
}
