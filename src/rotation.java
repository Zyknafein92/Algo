import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rotation {
    public static void main(String[] args) {
        List<Integer> given = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        int k = 3;
        System.out.println(rotationRight(given, 0));
    }

    private static List<Integer> rotationRight(List<Integer> given, int k) {
        List<Integer> result = new ArrayList<>();

        for(int i = Math.abs(k - given.size()); i < given.size(); i++){
            result.add(given.get(i));
        }

        for(int j = 0; j < Math.abs(k - given.size()); j++){
            result.add(given.get(j));
        }

        return  result;


    }
}
