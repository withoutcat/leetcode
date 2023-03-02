public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{1, 1};
        final int i = r.removeDuplicates(nums);
        System.out.println("数组长度为:" + i);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;

        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[writeIndex - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }
        return writeIndex;
    }
}
