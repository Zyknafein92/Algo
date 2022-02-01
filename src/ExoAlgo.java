import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExoAlgo {
    public static void main(String[] args) {
        int[] digits = new int[4];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = i;
        }
        System.out.println(plusOne(digits));
    }

    public static int[] plusOne(int[] digits) {
        StringBuilder number = new StringBuilder();
        String hashNumber;



        for (int i = 0; i < digits.length; i++) {
            number.append(i);
        }
        Integer incrementedValue = Integer.valueOf(String.valueOf(number) + 1);
        hashNumber = String.valueOf(incrementedValue);
        int[] result = new int[hashNumber.length()];

        for (int i = 0; i < hashNumber.length() ; i++) {
            String[] split = hashNumber.split("");
            result[i] = Integer.valueOf(split[i]);
        }

         return result;
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {
        /*
         1. Parcourir la fenêtre D.
         2. Récupérer le médian
         3. Faire le calcul
         */
        int notifications = 0;
        double median = 0;

        for (int i = 0; i < expenditure.size(); i++) {

        }

        if (d % 2 == 0) {

        } else {

        }
       return notifications;
    }
}
