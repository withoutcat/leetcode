package java;

import java.util.ArrayList;

public class FindMinFibonacciNumbers {
    public static void main(String[] args) {
        FindMinFibonacciNumbers f = new FindMinFibonacciNumbers();
        int k = 6;
        int ans = f.findMinFibonacciNumbers(k);
        System.out.println(ans + "");
    }
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) return 1;
        ArrayList<Integer> list = new ArrayList<>();
        // build fibonacci list
        int f1 = 1;
        list.add(f1);
        int f2 = 1;
        list.add(f2);
        int fn = 0;
        while (f1 + f2 <= k) {
            fn = f1 + f2;
            // 正好
            if (k == fn) return 1;

            list.add(fn);
            f1 = f2;
            f2 = fn;
        }

        // 其他情况 从f1(长度-2)开始缩小
        // F2就是最后一个 不动
        int ans = 2;
        int sum = 0;
        for (int i = list.size() - 2; i > 0; i--) {
            f1 = list.get(i);
            sum = f2 + f1;
            if (sum == k) return ans;
            if (sum > k) continue;
            if (sum < k) {
                ans++;
                f2 = sum;
            }
        }
        return ans;
    }
}