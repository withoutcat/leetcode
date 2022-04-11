package leetCode;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        final int i = m.maxSubArray(new int[]{5, 4, -1, 7, 8});
        System.out.println(i);

    }

    // 两次for循环真的傻逼，直接被超长数组教做人
    // public int maxSubArray(int[] nums) {
    //     int result = nums[0];
    //     for (int i = 0; i < nums.length; i++) {
    //         int temp = 0;
    //         for (int j = i; j < nums.length; j++) {
    //             temp += nums[j];
    //             result = Math.max(result, temp);
    //         }
    //     }
    //     return result;
    // }

    // 抄的作业
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }


}
