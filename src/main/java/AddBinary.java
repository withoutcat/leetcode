public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        AddBinary add = new AddBinary();
        final String s = add.addBinary(a, b);
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        boolean carry = false;
        StringBuilder sb = new StringBuilder();
        while (indexA >= 0 || indexB >= 0) {
            char ca = indexA >= 0 ? a.charAt(indexA) : '0';
            char cb = indexB >= 0 ? b.charAt(indexB) : '0';
            int n = ca + cb;
            switch (n) {
                case 98 -> {
                    sb.insert(0, carry ? '1' : '0');
                    carry = true;
                }
                case 97 -> sb.insert(0, carry ? '0' : '1');
                default -> {
                    sb.insert(0, carry ? '1' : '0');
                    carry = false;
                }
            }

            indexA--;
            indexB--;
        }
        if (carry)
            sb.insert(0, '1');
        return sb.toString();
    }
}
