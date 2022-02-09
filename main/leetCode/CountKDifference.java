package leetCode;

import java.util.HashMap;

public class CountKDifference {
    public static void main(String[] args) {
        CountKDifference c = new CountKDifference();
        int ans = c.countKDifference(new int[]{3,2,1,5,4}, 2);
        System.out.println(ans);
    }

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        // k:元素值, v:出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 从数组左边到右边只遍历一次，
            if (map.containsKey(num))
                // 能进到这里的，肯定是i=0的第一遍遍历
                map.put(num, map.get(num) + 1);
                // 后续遍历重复的话，value+1
            else map.put(num, 1);

            // 开始找绝对值为K的数
            int a = num - k;
            if (a > 0)
                // 这里判断一下是为了减少一次containsKey的操作
                // if判断的时间复杂度虽然跟containsKey一样都是O1，但是执行时间一定比containsKey要短
                if (map.containsKey(a)) count += map.get(a);
            int b = num + k;
            if (map.containsKey(b)) count += map.get(b);
        }
        return count;

        // 肯定对 但是没意思
        // int count = 0;
        // for (int i = 0; i < nums.length - 1; i++) {
        //     for (int j = i; j < nums.length; j++) {
        //         if (Math.abs(nums[i] - nums[j]) == k)
        //             count++;
        //     }
        // }
        // return count;
    }


}
