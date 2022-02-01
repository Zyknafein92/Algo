import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoTruc {

    public static void main(String[] args) {
//        // inverser un integer => 13567 => 76531. n > 0
//
////        Integer n = 13567;
////        if (n > 0) {
////            String value = n.toString();
////            String inverseValue = "";
////            for (int i = value.length() - 1; i >= 0 ; i--) {
////                inverseValue += value.charAt(i);
////            }
////
////            Integer result = Integer.parseInt(inverseValue);
////            System.out.println(result);
////        }
//
//        List<Integer> value1 = new ArrayList<>();
//        value1.add(1);
//        value1.add(2);
//        value1.add(4);
//        List<Integer> value2 = new ArrayList<>();
//        value2.add(1);
//        value2.add(3);
//        value2.add(4);
//        /*List<Integer> value1 = new ArrayList<>();
//        List<Integer> value2 = new ArrayList<>();
//       value1.add(0);*/
//
//
//        int i = 0, j= 0;
//        List<Integer> result = new ArrayList<>();
//        /*for(int k = 0; k < Math.max(value1.size(), value2.size()); k++) {
//
//        }*/
//        int [] values1;
//        int [] values2;
//        while( i < value1.size() && j < value2.size()) {
//            if(value1.get(i) < value2.get(j)) {
//                result.add(value1.get(i));
//                i++;
//            } else  {
//                result.add(value2.get(j));
//                j++;
//            }
//        }
//        if (i >= value1.size()) {
//            while(j < value2.size()) {
//                result.add(value2.get(j)); j++;
//            }
//        }
//        if (j >= value1.size()) {
//            while(i < value1.size()) {
//                result.add(value1.get(i)); i++;
//            }
//        }
//
//
//        while (!value1.isEmpty() && !value2.isEmpty()) {
//
//            if (value1.get(0) > value2.get(0)) {
//                result.add(value2.get(0));
//                value2.remove(value2.get(0));
//            } else {
//                result.add(value1.get(0));
//                value1.remove(value1.get(0));
//            }
//        }
//        result.addAll(value1);
//        result.addAll(value2);
//            System.out.println(result);

        //////////////

//        String result = "";
//        for (int k = 1; k < 10; k++) {
//            for (int l = 0; l < 10; l++) {
//                result = k + "" + l;
//                System.out.println(result);
//            }
//        }

        /////////

        String result = "";


        for (int i = 1; i < 10; i++) {
            for (int j = 9; j >= 0; j--) {
                result = i + "" + j + " ";
                System.out.print(result);
            }
            System.out.println("");
        }

//        int[] arr = new int[100];
//
//        for (int i = 0; i < 100; i++) {
//            arr[i] = (int) (Math.random() * 100 ) + 1;
//            System.out.println(arr[i]);
//        }
        ///
//        int k = 5;
//        int n = 100;
//
//        int result = Integer.MAX_VALUE;
//
//        int currentMulti = 0;
//        // calculer multiplication minimum
//
//        for (int i = 0; i < (n - k); i++) {
//           int multi = 1;
//            if(i == 0) {
//                for (int j = 0; j < k; j++) {
//                    multi *= arr[i + j];
//                }
//            } else {
//                multi = currentMulti / arr[i-1] * arr[i + k - 1];
//            }
//            currentMulti = multi;
//
//            if(result < currentMulti) result = currentMulti;
//        }
//
//        System.out.println(result);


        //... 10 22 31 4 5 5 63 6 ...

        // System.out.print ===> print one line
        // System.out.println ===> print one line and go to another line

        // 19 18 17 ... 10
        // 29 28 27 ... 20
        // ...
        // 99 98 97 ... 90


    }
}
