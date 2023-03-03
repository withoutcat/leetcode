public class MiniParser {
    public static void main(String[] args) {
        // String s = "[123,[456,[789]]]";
        String s = "123";
        MiniParser m = new MiniParser();
        final NestedInteger deserialize = m.deserialize(s);
        System.out.println(deserialize);
    }

    public NestedInteger deserialize(String s) {
        return deserializeWithIndex(s, 0);
    }

    public NestedInteger deserializeWithIndex(String s, int index) {
        StringBuilder sb = new StringBuilder();
        NestedInteger nest = new NestedInteger();
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ',') {
                nest.setInteger(Integer.parseInt(sb.toString()));
                nest.add(deserializeWithIndex(s, ++i));
                return nest;
            }
            if (c == '[' || c == ']') continue;
            sb.append(c);
        }
        nest.setInteger(Integer.parseInt(sb.toString()));
        return nest;
    }
}
