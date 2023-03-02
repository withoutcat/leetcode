public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        final int search = b.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] > target || nums[end] < target) return -1;

        while (end - start > 0) {
            if (nums[start] == target) return start;
            if (nums[end] == target) return end;
            int mid = (end - start) / 2 + start;
            int num = nums[mid];
            if (num == target)
                return mid;
            else if (num > target) {
                end = mid - 1;
                if (nums[end] == target)
                    return end;
            } else {
                start = mid + 1;
                if (nums[start] == target)
                    return start;
            }
        }
        return -1;
    }


}
