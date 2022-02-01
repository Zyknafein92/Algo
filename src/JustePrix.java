
import java.util.*;
import java.util.stream.Collectors;

public class JustePrix {

    public static void main(String[] args) {
        System.out.println("---------Bienvenue sur le JustePrix ---------");
        boolean play = true;
        Integer gameResult;
        Integer gamePlayed = 0;
        HashMap<Integer,Integer> gamesStats = new HashMap<>();

        while(play) {
            gameResult = game();
            gamePlayed++;
            if (gameResult > 0) {
                gamesStats.put(gamePlayed, gameResult);
            } else {
                gamesStats.put(gamePlayed, gameResult);
            }
            System.out.println("Souhaitez-vous rejouer ?");
            System.out.println("0 - Non");
            System.out.println("1 - Oui");
            Scanner sc = new Scanner(System.in);
            int value = sc.nextInt();
            if (value == 1 ) {
                play = true;
            } else {
                play = false;
                System.out.println(gameResult(gamePlayed,gamesStats));
            }
        }


    }

    private static Integer game() {
        Random rand = new Random();
        int MAX_TRIES = 5;
        int tryCount = 1;
        Integer result = 0;

        int price = 45;//20 + rand.nextInt(101 - 20);
        // nextInt(n) return une valeur entre 0 - n
        // il faut générer une valeur entre j<= v <= k
        // nextInt(99) 0 <= 98 < 99
        // 0 + 2 <= 99 + 2 < 99 + 2
        // 20 + rand.nextInt(100 - 20)

        boolean win = false;
        while (!win && tryCount <= MAX_TRIES) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Veuillez sélectionner un nombre :");
            int value = sc.nextInt();
            System.out.println(compareValue(value, price));
            if(compareValue(value,price).equals("Bingoooo ! Vous avez réussi !")) {
                win = true;
            } else {
                tryCount++;
            }
        }
        if (win) {
            System.out.println("Il vous a fallu : " + tryCount + "  tentatives !");
            result = tryCount;
        } else {
            result = -1;
            System.out.println("Wonwonwon. Perdu ! Vous avez utilisé toutes vos chances !");
        }
        return result;
    }

    private static String compareValue(int value, int price) {
        String result;
        if(price > value) {
            result = "C'est plus";
        } else if (price < value ) {
            result = "C'est moins";
        } else {
            result = "Bingoooo ! Vous avez réussi !";
        }
        return result;
    }

    private static String gameResult(Integer gamePlayed, HashMap<Integer, Integer> gamesStats) {
        StringBuilder sb = new StringBuilder();
        /*sortResult(gamesStats);
        String description =  "Réussi en " + gameResult + (gameResult > 1 ? " tentatives" : "tentative");
        sb.append("Vous avez joué : " + gamePlayed);
        sb.append("\n");
        for (Map.Entry<Integer,String> g : gamesStats.entrySet()) {
            sb.append(g.getKey() +  " :  " + g.getValue());
            sb.append("\n");
        }*/

        List<Map.Entry<Integer, Integer>> entriesSuccess = gamesStats.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .collect(Collectors.toList());
        entriesSuccess.sort((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : - 1);
        sb.append("Vous avez joué : " + gamePlayed);
        sb.append("\n");
        for (Map.Entry<Integer, Integer> g : entriesSuccess) {
            String description =  "Réussi en " + g.getValue() + (g.getValue() > 1 ? " tentatives" : " tentative");
            sb.append(g.getKey() +  " :  " + description);
            sb.append("\n");
        }
        List<Map.Entry<Integer, Integer>> entriesFailure = gamesStats.entrySet()
                .stream()
                .filter(entry -> entry.getValue() < 0)
                .collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> f : entriesFailure) {
            sb.append(f.getKey() + " : " + "Echec");
            sb.append("\n");
        }
        return sb.toString();
    }

}
