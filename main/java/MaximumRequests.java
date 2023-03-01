package java;


public class MaximumRequests {
    public static void main(String[] args) {
        MaximumRequests ma = new MaximumRequests();
        int ans = ma.maximumRequests(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 0},
                new int[]{3, 4}
        });
        System.out.println(ans);
    }

    public int maximumRequests(int n, int[][] requests) {
        int count = 0;
        // 二维数组，一维代表楼号，二维中0：搬出请求，1：搬入请求
        int[][] requestQueue = new int[5][2];
        // 遍历请求，并变成以楼为行的队列Map
        for (int[] req : requests) {
            // 处理搬出请求
            int[] moveOutBuilding = requestQueue[req[0]];
            if (moveOutBuilding[1] > 0) {
                // 如果有搬出请求的话，匹配订单
                moveOutBuilding[1] -= 1;
                count++;
            } else
                // 没有的话，加入队列
                moveOutBuilding[0] += 1;

            // 处理搬入请求
            int[] moveInBuilding = requestQueue[req[1]];
            if (moveInBuilding[0] > 0) {
                // 如果有搬出请求的话，匹配订单
                moveInBuilding[0] -= 1;
                count++;
            } else
                //没有的话，加入队列
                moveInBuilding[1] += 1;
        }

        return count;
    }
}
