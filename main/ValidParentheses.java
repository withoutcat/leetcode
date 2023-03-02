public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(){}[";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(s));
    }

    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (sb.length() > 0) {
                int lastIndex = sb.length() - 1;
                char otherC = sb.charAt(lastIndex);
                if (isPaired(otherC, c)) {
                    sb.deleteCharAt(lastIndex);
                    continue;
                }
            }
            sb.append(c);
        }
        return sb.isEmpty();
    }

    public boolean isPaired(char c1, char c2) {
        return switch (c1) {
            case '(' -> c2 == ')';
            case '[' -> c2 == ']';
            case '{' -> c2 == '}';
            default -> false;
        };
    }
}
