package java;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {

    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        int numsI;
        int numsNumsI;
        for (int i = 0; i < ans.length; i++) {
            numsI = nums[i];
            numsNumsI = nums[numsI];
            ans[i] = numsNumsI;
        }
        return ans;
    }
}
