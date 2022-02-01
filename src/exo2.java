import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.function.Function;



import static java.util.stream.Collectors.*;

public class exo2 {

    public static void main(String[] args) {
        // countCharacterNumber("Félicitation Fatima");
//        countSubStringApAndChange("Attestations de déplacement : le guide pratique pour s’y retrouverat", "ati", ":::");
        execerciseStack("()");
        execerciseStack("())(");
        execerciseStack(")()(");
        execerciseStack("())(()");
        execerciseStack("()()()");
    }

    private static void countCharacterNumber(String string) {
        /*
        décrire l'algo
       Récupérer le string et le passer en char. Eliminer l'espace. Ajouter une map clé: carac, valeur: nombre d'apparition. Créer un sysout correspondant (? besoin passer par un for each?)
         */
        Map<Character,Integer> letters= new HashMap<>();
        List<Character> characters = string.chars().filter(c -> c != ' ').mapToObj(c -> (char) c).collect(toList());

        for (Character c: characters) {
            if(!letters.containsKey(c)) {
                letters.putIfAbsent(c,1);
            } else {
                letters.put(c,letters.get(c)+1);
            }
        }

        Map<Character, Long> counts = characters.stream().collect(groupingBy(Function.identity(), counting()));
        System.out.println(counts);
        letters.keySet().forEach(l -> System.out.println(l.toString() + " : " + letters.get(l)));
        counts.keySet().forEach(l -> System.out.println(l.toString() + " : " + counts.get(l)));
        letters.clear();
        characters.stream().forEach(c -> {
            letters.putIfAbsent(c, 0);
            letters.put(c, letters.get(c) + 1);
        });

    }

    /*
     * charactère: nombre d'apparaitre
     * F: 2, i: 4, ..
     * */
    /*

    remplacer substring dans un string
    ex: "Attestations de déplacement : le guide pratique pour s’y retrouver"
    sub: "at"
    pb: calculer le nombre d'apparision
    et après, remplacer sub string par :::

     */

    private static void countSubStringApAndChange(String string, String sub, String toReplace) {
//        String ori = "Attestations de déplacement : le guide pratique pour s’y retrouverat";
//        List<String> stringList = Arrays.asList(string.split(""));
//        stringList = new ArrayList<>(stringList);
//        int count = 0;
//        ArrayList<Integer> index = new ArrayList<>();
//        for (int i = 0; i < stringList.size(); i++) {
//            if (stringList.get(i).equals("a") && stringList.get(i + 1).equals("t")) {
//                System.out.println("before remove " + stringList.size());
//                System.out.println(stringList);
//                stringList.remove(i+1);
//                stringList.remove(i);
//                System.out.println("after remove " + stringList.size());
//                System.out.println(stringList);
//                // stringList.add(i,  ":::");
//                System.out.println("after add ::: " + stringList.size());
//                System.out.println(stringList);
//                count++;
//                // remove élément à i et à i+1
//                // ajouter 3 fois : à la position i
//                // [] -> i // remove;
//            }
//
//        }
//
//        String result = String.join("", stringList);
//
//        System.out.println(index);
//        System.out.println(result);
//String result = string.replaceAll(".*", ":::");
// string.replace("at", ":::");
//System.out.println("at est présent : " + count + " fois et le string après modification :  " + result);

      /*
    donné: un string s1 ( Attestations de déplacement : le guide pratique pour s’y retrouverat ) (fixe)
    donné: un autre string s2 (at) (données dynamiques)
    donné: un autre string s3 (:::) (données dynamiques)
    à faire: remplacer s2 dans s1 (si existe) par s3
     */
        List<String> stringList = Arrays.asList(string.split(""));
        stringList = new ArrayList<>(stringList);
        int subLength = sub.length();
        int position;
        int count = 0;

        System.out.println(Arrays.stream(string.split(sub)).collect(joining(toReplace)));
        string.replace(sub, toReplace);
        while (string.contains(sub)) {
            /*position = string.indexOf(sub);
            while (subLength != 0) {
                stringList.remove(position + subLength-- - 1 - (2 * count));
                System.out.println(stringList.stream().collect(joining()));
            }
            subLength = sub.length();
            stringList.add(position - (2 * count), toReplace);
            string = StringUtils.join(stringList, "");
            System.out.println(string.length());
            System.out.println(string.indexOf(sub));
            System.out.println(stringList.indexOf(sub));
            count++;*/
            stringList = new ArrayList<>(Arrays.asList(string.split("")));
            position = string.indexOf(sub);
            while (subLength > 0) {
                stringList.remove(position);
                subLength--;
            }
            stringList.add(position, toReplace);
            subLength = sub.length();
            string = stringList.stream().collect(joining());


        }



        System.out.println(string);

    }





    public static void execerciseStack(String expression) {
        //condition = ouverture fermeture correcte
        Stack<String> test = new Stack<>();
        List<String> condition = new ArrayList<>();
        Arrays.stream(expression.split("")).forEach(test::push);
        int countRight = 0;
        int countLeft = 0;

        while (!test.isEmpty()) {
            String pop = test.pop();
            if (pop.equals("(")) {
                countLeft++;
                condition.add(pop);
            }
            if (pop.equals(")")) {
                countRight++;
                condition.add(pop);
            }
        }
        if (countLeft != countRight) {
            System.out.println("Erreur, tu l'as dans l'os");
        } else {
            Collections.reverse(condition);
            while (!condition.isEmpty()) {
                if (condition.get(0).equals("(") && condition.get(condition.size() - 1).equals(")")) {
                    condition.remove(0);
                    condition.remove(condition.size() - 1);
                } else {
                    System.out.println("Erreur, tu l'as dans l'os");
                    break;
                }
            }
        }
        if (condition.isEmpty()) System.out.println("Eureka ! Ils sont pareils !");
    }
}
