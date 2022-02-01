import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Arrays {
    public static void main(String[] args) {
        // [[1, 3, 5], [8,7,0,9], [9, 8, 9, 7, 4], [3,2]]
        // find -> average
        // find max average
        // find max temp

        // [1, 2, 5, 9, 5, 4]
        // verify if array contains only unique value
        int[] value = new int[]{1, 2, 5, 9, 5, 4};
        int[][] temperature = new int[][]{{1, 3, 5}, {8,7,0,9},{9, 8, 9, 7, 4}, {3,2}};
        double[]  result = findAverage(temperature);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        System.out.println("The max average is:" + findMaxAverage(result));
        System.out.println(findMaxTemperature(temperature));
        System.out.println(findMaxTemperaturePosition(temperature));
        System.out.println(isValueisUniqueWithCollection(value));
        System.out.println(isValueisUniqueWithoutCollection(value));
    }

    private static boolean isValueisUniqueWithoutCollection(int[] value) {
        boolean result = true;
        for (int i = 0; i < value.length; i++) {
            int count = 0;
            int temp = value[i];
            for (int j = 0; j < value.length; j++) {
                if(temp == value[j]) {
                    count++;
                }
                if(count > 1) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private static boolean isValueisUniqueWithCollection(int[] value) {
        Set<Integer> presentValue = new HashSet<>();
        boolean result = true;
        for (int i = 0; i < value.length; i++) {
            /*if(presentValue.contains(value[i])) {
                result = false;
                break;
            }
                presentValue.add(value[i]);*/
            if(!presentValue.add(value[i])) {
                return false;
            }
        }
        return result;
    }

    private static String findMaxTemperaturePosition(int[][] temperature) {
        int posI = 0;
        int posJ = 0;
        boolean isFind = false;

        for (int i = 0; i < temperature.length; i++) {
            for (int j = 0; j < temperature[i].length; j++) {
                if(temperature[i][j] == findMaxTemperature(temperature)) {
                    posI = i;
                    posJ = j;
                    isFind = true;
                }
            }
            if (isFind) break;
        }
        return "La position de la température max est = I:" + posI + " J: " + posJ;
    }

    private static int findMaxTemperature(int[][] temperature) {
        int maxTemp = 0;
        for (int i = 0; i < temperature.length; i++) {
            for (int j = 0; j < temperature[i].length; j++) {
                if(maxTemp < temperature[i][j]) maxTemp = temperature[i][j];
            }
        }
        return maxTemp;
    }

    private static double findMaxAverage(double[] result) {
        double maxValue = 0;
//        for (int i = 0; i < result.length; i++) {
//            if(result[i] > maxValue) {
//                maxValue = result[i];
//            }
//        }
        //        return  maxValue;
    return java.util.Arrays.stream(result).max().getAsDouble();
    }

    private static double[] findAverage(int[][] temperature) {
        // 2 x for, 1 - calculer dans chaque ville la moyenne -> retourner un tableau unique
        double[] result = new double[temperature.length];
        for (int i = 0; i < temperature.length; i++) {
            result[i] = calculateAverage(temperature[i]);
        }
        return result;
    }

    private static double calculateAverage(int[] temperature) {
        double result = 0d;

//        for (int i = 0; i < temperature.length; i++) {
//            result += temperature[i];
//        }
//        return  result / temperature.length;
        return java.util.Arrays.stream(temperature).average().getAsDouble();
    }
}
