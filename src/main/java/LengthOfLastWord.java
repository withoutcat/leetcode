public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord l = new LengthOfLastWord();
        final int s = l.lengthOfLastWord3("  s  ");
        System.out.println("\n" + s);
    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.print(c);
            if (c != ' ')
                temp++;
            else if (i != s.length() - 1)
                temp = 0;
            result = temp;
        }
        return result;
    }

    public int lengthOfLastWord1(String s) {
        final String[] split = s.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isEmpty()) return split[i].length();
        }
        return 0;
    }

    public int lengthOfLastWord2(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') result++;
            else if (result != 0) break;
        }
        return result;
    }

    public int lengthOfLastWord3(String s) {
        String[] word = s.split(" ");
        s = word[word.length - 1];
        return s.length();
    }

}
