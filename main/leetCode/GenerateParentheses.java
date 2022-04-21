package leetCode;

import java.util.*;

public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        final List<String> strings = g.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        backtracking(n, n, new StringBuffer());
        return res;
    }

    private void backtracking(int left, int right, StringBuffer path) {
        if (left == 0 && right == 0) {
            res.add(path.toString());
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            path.append("(");
            backtracking(left - 1, right, path);
            path.deleteCharAt(path.length() - 1);
        }
        if (left < right) {
            path.append(")");
            backtracking(left, right - 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
