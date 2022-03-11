package leetCode;

public class LongestCommonPrefix {
    private static final String STRING = "abcdefghijklmvopqrstuvwxyz";
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = new String[]{
                "flower","flower","flower","flower"
                // "ab","a"
        };

        String result = l.longestCommonPrefix(strs);
        System.out.println(result);

    }

    public String longestCommonPrefix(String[] strs) {
        String headStr = strs[0];
        if (strs.length == 1) return strs[0];
        if ("".equals(strs[0])) return "";

        int preIndex = 0;
        w:
        while (true) {
            char currentChar = headStr.charAt(preIndex);
            for (int i = 1; i < strs.length; i++) {
                if ("".equals(strs[i])) return "";
                if (preIndex >= strs[i].length()) {
                    preIndex--;
                    break w;
                }
                char tempChar = strs[i].charAt(preIndex);
                if (tempChar != currentChar) {
                    preIndex--;
                    break w;
                }

            }
            if (preIndex < (headStr.length() - 1)) ++preIndex;
            else break;
        }

        // finally
        // if (preIndex == 0) return "";
        return headStr.substring(0, preIndex+1);
    }

    /**
     * @param m 开始（包含）
     * @param n 结束（包含）
     * @return 随机整数
     */
    static int randomInt(int m, int n) {
        return m + (int) (Math.random() * (n + 1 - m));
    }

    static String randomStr() {
        sb.delete(0, sb.length());
        int strLen = randomInt(0, 200);
        for (int i = 0; i < strLen; i++) {
            int randomIndex = randomInt(0, STRING.length() - 1);
            sb.append(STRING.charAt(randomIndex));
        }
        return sb.toString();
    }


}
