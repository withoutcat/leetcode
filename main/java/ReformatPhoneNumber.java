package java;

class ReformatPhoneNumber {
    public static void main(String[] args) {
        ReformatPhoneNumber r = new ReformatPhoneNumber();
        // 156-665-565-69-91
        String s = r.reformatNumber(" 1 5-6  -112-11-1 1");
        System.out.println(s);

    }
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 跳过'-' 和 空格' '
            if (c == '-' || c == ' ') {
                continue;
            }
            // 加入sb并计数
            sb.append(c);
            count++;
            if (count % 3 == 0) {
                sb.append('-');
            }
        }
        // 去尾
        if (sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        // 如果剩4个的情况, 需要平移最后一个'-'
        if (count % 3 == 1) {
            // 把倒数第二个和倒数第三个交换位置
            char secondLast = sb.charAt(sb.length() - 2);
            char thirdLast = sb.charAt(sb.length() - 3);
            sb.replace(sb.length() - 2, sb.length() - 1, String.valueOf(thirdLast));
            sb.replace(sb.length() - 3, sb.length() - 2, String.valueOf(secondLast));
        }
        return sb.toString();
    }
}