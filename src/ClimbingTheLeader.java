//import java.sql.SQLOutput;
//import java.util.*;
//
//public class ClimbingTheLeader {
//
//    public static void main(String[] args) {
//        List<List<Integer>> data1 = data1();
//        List<Integer> result;
//        List<Integer> expected = new ArrayList<>(Arrays.asList(6,5,4,2,1));
//        result = climbingLeaderboard(data1.get(0),data1.get(1));
//        verification(result,expected);
//    }
//
//    public static List<List<Integer>> data1() {
//        List<List<Integer>> patate = new ArrayList<>();
//        List<Integer> ranked = new ArrayList<>();
//        List<Integer> player = new ArrayList<>();
//
//        ranked.add(100);
//        ranked.add(90);
//        ranked.add(90);
//        ranked.add(80);
//        ranked.add(75);
//        ranked.add(60);
//
//        player.add(50);
//        player.add(65);
//        player.add(77);
//        player.add(99);
//        player.add(102);
//
//        patate.add(ranked);
//        patate.add(player);
//
//        return patate;
//    }
//
//    public static void verification (List<Integer> result, List<Integer> expected) {
//        if(result.size() != expected.size()) {
//            System.out.println("Error, tu l'as dans l'...");
//            return;
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            if(!result.get(i).equals(expected.get(i))) {
//                System.out.println("Error, tu l'as dans l'...");
//                return;
//            }
//        }
//        System.out.println("Winner !");
//    }

//    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
////        for (int i = 0; i < ranked.size() || j >= 0;) {
////            if (ranked.get(i) > player.get(j)) {
////                ladder.add(ranked.get(i));
////                i++;
////            } else if (ranked.get(i) < player.get(j)) {
////                j--;
////                result.add(0,ladder.size());
////            } else {
////                ladder.add(ranked.get(i));
////                i++;
////            }
////
////            System.out.println("Ladder:" + ladder);
////            System.out.println("Result:" + result);
////        }
////        return result;
//
////        SortedSet<Integer> ladder = new TreeSet<>();
////        List<Integer> result = new ArrayList<>();
////
////        for (Integer rank: ranked) {
////
////            System.out.println(ladder);
////        }
//
//
////        6 rank
////        100 90 80 75 60
////        5 alice
////        50 65 77 90 102
////        for(Integer alice: player) {
////            int counter = ladder.size() + 1;
////            for( int i = ladder.size() - 1; i >=0; i--) {
////                if(alice > ladder.get(0)) {
////                    result.add(1);
////                    break;
////                }
////                else if(alice < ladder.get(i)) {
////                    result.add(counter);
////                    break;
////                } else if (alice.equals(ladder.get(i))) {
////                    counter--;
////                    result.add(counter);
////                    break;
////                } else {
////                    counter--;
////                }
////            }
////            System.out.println(result);
////        }
////        return result;
////    }
//    }
