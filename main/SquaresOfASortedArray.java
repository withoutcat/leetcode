import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        SquaresOfASortedArray s = new SquaresOfASortedArray();
        final int[] ints = s.sortedSquares2(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
    }

    // 这种傻逼思维啊，就是典型的用人脑去指挥二极管
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int addIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            result[i] = n * n;
        }
        Arrays.sort(result);
        return result;
    }

    // 双指针
    public int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int l = nums[left];
            int r = nums[right];
            if (Math.abs(l) >= Math.abs(r)) {
                result[i] = l * l;
                left++;
            } else {
                result[i] = r * r;
                right--;
            }
        }
        return result;
    }


}
