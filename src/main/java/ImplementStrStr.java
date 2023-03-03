public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr i = new ImplementStrStr();
        final int i1 = i.strStr1("1231234", "1234");
        System.out.println(i1);
    }

    // 实际上是个暴力算法，而且没跑通，但是思路对，细节调一调就通了，之所以没写完是因为strStr1()方法，使得这道题没有意义了
    // public int strStr(String haystack, String needle) {
    //     int i = 0;
    //     mark:
    //     while (i < haystack.length()) {
    //         if (haystack.charAt(i) == needle.charAt(0)) {
    //             if (i < haystack.length() - needle.length()) {
    //                 for (int j = 1; j < needle.length(); j++) {
    //                     if (haystack.charAt(i + j) != needle.charAt(j)) {
    //                         i += j;
    //                         continue mark;
    //                     }
    //                 }
    //             }
    //             return i;
    //         }
    //         i++;
    //     }
    //     return -1;
    // }


    // 官方的kmp算法，看不太懂
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
