import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlgoHKRK {

    public static int diagonalDifference(List<List<Integer>> arr) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int [] v;

        for (int i = 0; i < arr.size(); i++) {
            a.add(arr.get(i).get(i));
        }

        System.out.println(a);
        ;
        int k = 0;
        for (int j = arr.size(); j-- > 0; ) {
            b.add(arr.get(j).get(k));
            k++;
        }
        System.out.println(b);

        return Math.abs(a.stream().reduce(0,Integer::sum) - b.stream().reduce(0,Integer::sum));
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        a.add(11);
        a.add(2);
        a.add(4);
        b.add(4);
        b.add(5);
        b.add(6);
        c.add(10);
        c.add(8);
        c.add(-12);
        arr.add(a);
        arr.add(b);
        arr.add(c);
        Integer x = diagonalDifference(arr);
        System.out.println(x);
    }
}
