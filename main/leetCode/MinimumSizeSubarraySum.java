package leetCode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while (left < right) {
            int l = nums[left];
            int r = nums[right];
            if (l + r == target)
                result = r - l;
            else {
                if (lef)
            }
        }
        return result;
    }
}
