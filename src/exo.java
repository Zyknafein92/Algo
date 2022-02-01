import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class exo {

    public static void main(String[] args) {
        // Savoir si la liste a un doublon, sans grand impact sur la mémoire.
        List<Integer> notes = Arrays.asList(1, 2, 3, 4, 1);
        /*List<Integer> notesCopy = new ArrayList<>(notes);
        Set<Integer> val = new HashSet<>();

        List<Integer> collect = notesCopy.stream().filter(t -> val.add(t)).collect(toList());
        System.out.println(val);


        System.out.println(collect);*/
//        System.out.println(notes.stream().collect(Collectors.toSet()));
        //

        Map<Integer,Integer> valMap = new HashMap<>();
        notes.forEach(t -> {
            valMap.putIfAbsent(t,0);
            valMap.put(t, valMap.get(t)+1);
        });

        List<Integer> collect = valMap.entrySet().stream().filter(t -> t.getValue() < 2).map(Map.Entry::getKey).collect(toList());
        System.out.println(collect);



    }

    private  void backup() {
        /*/Set<Integer> doublon = new HashSet<>();
        List<Integer> notesCopy = new ArrayList<>(notes);

        /*for (Integer val: notesCopy) {
            boolean addResult = doublon.add(val);
            if(addResult) {
                notesCopy.remove(val);
            }
        }
        Iterator<Integer> notesCopyIterator = notes.iterator();
        while (notesCopyIterator.hasNext()) {
            Integer val = notesCopyIterator.next();
            boolean addResult = doublon.add(val);
            if(addResult) {
                notesCopy.remove(val);
            }
        }
        //System.out.println(notesCopy);

        doublon.clear();
        notes.stream().filter(t -> !doublon.add(t)).forEach(t -> System.out.println(t));

        *Map<Integer, Integer> note = new HashMap<Integer, Integer>();


        for (Integer val : notes) {
            if (note.containsKey(val)) {
                note.put(val, note.get(val) + 1);
            } else {
                note.put(val, 1);
            }
        }

        // List<Map.Entry<Integer, Integer>> collect = note.entrySet().stream().filter(value -> value.getValue().equals(1)).collect(toList());
        List<Map.Entry<Integer, Integer>> collect1 = note.entrySet().stream().filter(value -> value.getValue() >= 2).collect(toList());


        // Value v= ? exists ? times
        note.clear();
        for (int i = 0; i < collect1.size(); i++) {
            System.out.println("Value v=" + collect1.get(i).getKey() + " exists " + collect1.get(i).getValue() + " times");
        }

        notes.forEach(k -> {
                    note.putIfAbsent(k, 0);
                    note.put(k, note.get(k) + 1 );
                }
        );
        note.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println("Value v=" + entry.getKey() + " exists " + entry.getValue() + " times"));
    }
    // detecter les valeurs doublon et imprimer le nombre d'appraition
         */
    }

    // 12 77 2 122
    public static int[]  prodDelivery(int[] orderID)
    {
        /*Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        String s = scan.next();
        Double d = scan.nextDouble();*/
        int[] result = new int[orderID.length];
        for(int i = 0; i< orderID.length; i++) {
            String numberInString = String.valueOf(orderID[i]);
            String[] numberInLetters = numberInString.split("");
            int total = 0;
            for(int j = 0; j < numberInLetters.length; j++) {
                total += Integer.parseInt(numberInLetters[j]);
            }
            result[i] = total;
        }

        return Arrays.stream(Arrays.asList(orderID)
                .stream().map(id ->
                        Arrays.asList(
                                String.valueOf(id).split("")
                        ).stream()
                        .mapToInt(i -> Integer.parseInt(i)).sum()
                )
                .toArray(size -> new Integer[orderID.length]))
                .mapToInt(x -> x)
                .toArray();
    }

    public static int calculateSum(char[] numbersValue) {
        int sumResult = 0;
        for (int j = 0; j < numbersValue.length; j++) {
            sumResult += (int) numbersValue[j];
        }

        return sumResult;
    }

}

