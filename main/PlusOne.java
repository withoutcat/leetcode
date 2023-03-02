import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        int[] a = new int[]{8, 9, 9};

        System.out.println(Arrays.toString(p.plusOne(a)));
    }

    public int[] plusOne(int[] digits) {
        // 分扩容和不扩容两种情况
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] > 9 ? 1 : 0;
            digits[i] %= 10;
        }
        if (carry == 1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            System.arraycopy(digits, 0, arr, 1, digits.length);
            return arr;
        }
        return digits;
    }
}
