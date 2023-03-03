class DivideTwoIntegers {

    /**
     * 解出来了，但是Leetcode测试用例超时
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int count = 0;
        if (dividend > 0 && divisor > 0) {
            while (dividend >= divisor) {
                count++;
                dividend -= divisor;
            }
            // 都是正整数时，count也是正数，当到达int最大值时，++会变成int最小值，按照题目要求，需要撤回这最后一次++
            return count == Integer.MIN_VALUE ? Integer.MAX_VALUE : count;
        }
        if (dividend > 0 && divisor < 0) {
            while (dividend + divisor >= 0) {
                count++;
                dividend += divisor;
            }
            // count一定是负数，所以当count到达int最大值时，++变成int最小值正好是我们要的效果，其他情况则需要手动取反。
            return count == Integer.MIN_VALUE ? Integer.MIN_VALUE : ~count + 1;
        }
        if (dividend < 0 && divisor < 0) {
            while (dividend <= divisor) {
                count++;
                dividend -= divisor;
            }
            // 都是正整数时，count也是正数，当到达int最大值时，++会变成int最小值，按照题目要求，需要撤回这最后一次++
            return count == Integer.MIN_VALUE ? Integer.MAX_VALUE : count;
        }
        if (dividend < 0 && divisor > 0) {
            while (dividend + divisor <= 0) {
                count++;
                dividend += divisor;
            }
            // count一定是负数，所以当count到达int最大值时，++变成int最小值正好是我们要的效果，其他情况则需要手动取反。
            return count == Integer.MIN_VALUE ? Integer.MIN_VALUE : ~count + 1;
        }

        // dividend == 0 时
        return 0;
    }
}