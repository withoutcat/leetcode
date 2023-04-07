import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        
        System.out.println(Arrays.toString(fb.run(10)));
    }

    private int[] run(int num) {
        final int[] result = new int[num];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < num; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
