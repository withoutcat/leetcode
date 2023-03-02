import java.util.ArrayList;
import java.util.HashMap;

public class uncommonFromSentences {

    public static void main(String[] args) {
        uncommonFromSentences u = new uncommonFromSentences();
        String s1 = "apple apple", s2 = "banana";
        final String[] strings = u.uncommonFromSentences(s1, s2);
        System.out.println(strings);
    }


    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        final String[] words1 = s1.split(" ");
        put(hashMap, words1);

        final String[] words2 = s2.split(" ");
        put(hashMap, words2);

        ArrayList<String> list = new ArrayList<>();
        hashMap.entrySet().forEach(e -> {
            if (!e.getValue()) list.add(e.getKey());
        });
        String[] ans = new String[list.size()];
        return list.toArray(ans);
    }

    void put(HashMap<String, Boolean> hashMap, String[] words) {
        for (String s : words) {
            boolean value = hashMap.containsKey(s) ? true : false;
            hashMap.put(s, value);
        }
    }
}
