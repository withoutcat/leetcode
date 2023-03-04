import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAphoneNumber {
    public static void main(String[] args) {

    }

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        if (digits.length() == 1) {
            for (int i = 0; i < digits.length(); i++) {

            }
        }

        for (int i = 0; i < digits.length(); i++) {
            final String[] arr = getArr(digits.charAt(i));
            final String s = arr[0];


        }

        return null;
    }


    private String[] getArr(char c) {
        switch (c) {
            case '2': {
                return k2;
            }
            case '3': {
                return k3;
            }
            case '4': {
                return k4;
            }
            case '5': {
                return k5;
            }
            case '6': {
                return k6;
            }
            case '7': {
                return k7;
            }
            case '8': {
                return k8;
            }
            case '9': {
                return k9;
            }
            default: {
                return null;
            }
        }
    }

    String[] k2 = new String[]{"a", "b", "c"};
    String[] k3 = new String[]{"d", "e", "f"};
    String[] k4 = new String[]{"g", "h", "i"};
    String[] k5 = new String[]{"j", "k", "l"};
    String[] k6 = new String[]{"m", "n", "o"};
    String[] k7 = new String[]{"p", "q", "r", "s"};
    String[] k8 = new String[]{"t", "u", "v"};
    String[] k9 = new String[]{"w", "x", "y", "z"};

}
