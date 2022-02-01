import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CriticalRouters {

    public static void main(String[] args) {
        int numRouters = 7;
        int numLinks = 7;
        String links = "[[1, 2], [1, 3], [2, 4], [3, 4], [3, 6], [6, 7], [4, 5]]";
        Map<String, String> routerLinks = new HashMap<>();
        //Map int, ArrayList<Integer>

        String[] modifiedLinks = links.replaceAll("[^0-9]", "").split("");

        int j = 1;
        for (int i = 0; i < modifiedLinks.length - 1; i = i +2) {
          routerLinks.putIfAbsent(modifiedLinks[i],modifiedLinks[j]);
          if(routerLinks.containsKey(modifiedLinks[i])) {
              routerLinks.replace(String.valueOf(i), routerLinks.get(String.valueOf(i)), routerLinks.get(String.valueOf(i)) + ", " + modifiedLinks[j]);
          }
          j = j+2;
        }


        System.out.println("Routeur link : " + routerLinks);
        System.out.println("Valeur String: " + Arrays.toString(modifiedLinks));
    }
}
