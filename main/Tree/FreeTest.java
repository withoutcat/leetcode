package Tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FreeTest {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>() {{
            add("1");
            add("2");
            add("3");
        }};
        System.out.println(list);
    }

    /**
     * Check if string contains number after specific word
     *
     * @param contains string contains
     * @param key      the specific word (without comma)
     * @return yes or not
     */
    public boolean hasNumber(String contains, String key) {
        int commaIndex = contains.indexOf(',', contains.indexOf(key));
        int startIndex = commaIndex + 1;
        boolean hasNumber = true;
        while (true) {
            char c = contains.charAt(startIndex++);
            if (c == '/') break; // exit
            if (c != ' ') {
                hasNumber = Character.isDigit(c);
            }
        }
        return hasNumber;
    }


}
