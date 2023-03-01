package java;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        // System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{3, 4}));
        new MinimumSizeSubarraySum().test(1, 1, 1);
    }

    public int minSubArrayLen(int target, int[] nums) {
        // 第一次接触滑动窗口，是双指针的一种
        int end = 1;
        int start = 0, temp = 0, ans = 0;
        int sum = nums[start] + nums[end];
        while (start < nums.length - 1) {
            try {
                sum += temp;
                if (sum < target)
                    temp = nums[++end];
                else if (sum == target) {
                    int subLen = end - start + 1;
                    ans = ans == 0 ? subLen : Math.min(ans, subLen);
                    temp = nums[++end] - nums[start++];
                } else
                    temp = -nums[start++];
            } catch (Exception e) {
                // 唯一报错可能就是数组下标越界，所以用try catch来作为边界条件判定使代码整洁
                break;
            }
        }
        return ans;
    }

    public void test(int a, int b, int c) {
        if (a == 1) {
            if (b == 1)
                if (c == 0)
                    System.out.println("110");


            if (b == 0) {
                if (c == 1)
                    System.out.println("101");
                if (c == 0)
                    System.out.println("100");

            }
        }
    }
}
