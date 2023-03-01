package java;

import java.util.HashMap;

public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        lengthOfLongestSubstring l = new lengthOfLongestSubstring();
        // String s = "12345678900123456789abcc"; // 13
        // String s = "df1daghjs"; // 8
        // String s = "abacb123cbb"; // 3
        // String s = "   "; // 1
        // String s = "pwwkew"; // 3
        String s = "abcdefgcf";
        final int i = l.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        HashMap<Character, Integer> charMap = new HashMap<>();
        int current = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if(charMap.containsKey(c)) {
                // 更新最大长度
                if (current > longest)
                    longest = current;

                // 记录一下犯的错误，这里不能只用clear()，不然虽然模拟了子串的长度，但是子串的数据丢失了，就不能查重了
                // 应该去母串里补充，因为有下标，所以查找的时间复杂度是O1
                int lastCharIndex = charMap.get(c);
                current = i - lastCharIndex;
                charMap.clear();
                // 从重复元素的下一位开始一直到当前，都补齐
                for (int j = lastCharIndex + 1; j <= i; j++) {
                    charMap.put(s.charAt(j), j);
                }
            } else {
                charMap.put(c, i);
                current++;
            }
        }

        return current > longest ? current : longest;
    }

}
