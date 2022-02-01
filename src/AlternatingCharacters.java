import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AlternatingCharacters {



    public static void main(String[] args) {
        String s = "AAAA";
        String v = "aabbc";
        String c = "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
//      System.out.println(alternatingCharacters(s));
        System.out.println(isValid(v));
        System.out.println(isValid(c));
    }

    public static int alternatingCharacters(String s) {

        // Write your code here
        String[] sSplit = s.split("");
        int count = 0;

        for(int i = 0; i < sSplit.length; i++) {
            int j = i + 1;
            if(j < sSplit.length && sSplit[i].equals(sSplit[j])) {
                count++;
            }
        }
        return count;
    }

    public static String isValid(String s) {
        Map<String, Integer> counter = new HashMap<>();
        String[] sSplit = s.split("");
        int maxFreq = 0;


        for (String value : sSplit) {
            if (!counter.containsKey(value)) {
                counter.putIfAbsent(value, 1);
            } else {
                counter.put(value, counter.get(value) + 1);
                if(maxFreq < counter.get(value)) maxFreq = counter.get(value);
            }
        }
        System.out.println(counter.values());
        System.out.println(maxFreq);
        final int letterNumber = maxFreq;
        int minValue = Collections.min(counter.entrySet(), Map.Entry.comparingByValue()).getValue();

        if(counter.values().stream().allMatch(v -> v == letterNumber)) {
            return "YES";
        } else {
            if(minValue - 1 == 0) {
                return "YES";
            }
        }
        return "NO";
    }
}
