import java.util.*;
import java.util.stream.Collectors;

public class PopularNToys {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> toysCount = new LinkedHashMap<>();

        int topToys = 2;

        String quotes = "Elmo is the hottest toy of the season! Elmo will be on every kid's wishlist!””The new Elmo dolls are super high quality.””Expect the Elsa dolls to be very popular this year’Elsa and Elmo are the toys I'll be buying for my kids.” +”For parents of older kids, look into buying them a drone.” +”Warcraft is slowly rising in popularity ahead of the holiday season.” ";

        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};

        String[] values = quotes.toLowerCase().split("””");

        for (String toy : toys) {
            toysCount.putIfAbsent(toy, 0);
        }

        for (String val : values) {
          String[] valModifier = val.replaceAll("[\\W]+", " ").split(" ");
          int increment = 1;
            for (String word : valModifier) {
                if (toysCount.containsKey(word) && toysCount.get(word) <= increment) {
                    toysCount.merge(word, 1, Integer::sum);
                    increment++;
                }
            }
        }

        System.out.println(toysCount);

        List<Map.Entry<String, Integer>> toysToMap =
                toysCount.entrySet()
                        .stream()
                        //.sorted(Map.Entry.comparingByValue())
                        .sorted((a, b) -> b.getValue() - a.getValue())
                        .collect(Collectors.toList());

        List<String> result = toysToMap.stream().map(Map.Entry::getKey).collect(Collectors.toList());

        for (int i = 0; i < topToys; i++) {
            System.out.println(result.get(i));
        }
  }
}
