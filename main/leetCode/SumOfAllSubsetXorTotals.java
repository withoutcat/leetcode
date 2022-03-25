package leetCode;

public class SumOfAllSubsetXorTotals {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 1, 6};
        SumOfAllSubsetXorTotals s = new SumOfAllSubsetXorTotals();
        final int i = s.subsetXORSum(arr);
        System.out.println(i);
    }
    public int subsetXORSum(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i];
            result += temp;
            for (int j = i + 1; j < nums.length; j++) {
                temp ^= nums[j];
                result += temp;
            }
        }
        result += nums[nums.length - 1];
        return result;
    }
}
