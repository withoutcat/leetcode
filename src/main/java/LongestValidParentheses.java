public class LongestValidParentheses {

  public static void main(String[] args) {
    LongestValidParentheses l = new LongestValidParentheses();
//    System.out.println(l.longestValidParentheses("(()"));
//    System.out.println(l.longestValidParentheses(")()())"));
//    System.out.println(l.longestValidParentheses(""));
//    System.out.println(l.longestValidParentheses("()"));
//    System.out.println(l.longestValidParentheses("()(()"));
//    System.out.println(l.longestValidParentheses("(()())"));

    System.out.println(l.longestValidParentheses("(()())"));
  }

  public int longestValidParentheses(String s) {
    boolean needCount = true;
    int cache = 0;
    int maxContinuous = 0;
    int currentContinuous = 0;
    for (int i = 0; i < s.length(); i++) {
      needCount = !needCount;
      cache += getCharValue(s.charAt(i));
      if (needCount) {
        if (cache == 0) {
          currentContinuous++;
        } else {
          maxContinuous = Math.max(maxContinuous, currentContinuous);
          cache = 0;
        }
      }
    }
    return maxContinuous;
  }

  private int getCharValue(char c) {
    switch (c) {
      case '(':
        return 1;
      case ')':
        return -1;
      default:
        return 0;
    }
  }
}