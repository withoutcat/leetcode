public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] nums = new int[]{0, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        final int i = r.removeElement(nums, 0);
        System.out.println("长度为:" + i);
        for (int j = 0; j < i; j++) {
            System.out.print(nums[j]);
        }
    }

    public int removeElement(int[] nums, int val) {
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[writeIndex++] = nums[i]; //这里writeIndex++的用法很有意思，评论区里学来的
        }
        return writeIndex;
    }
}
