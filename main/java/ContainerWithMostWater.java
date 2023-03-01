package java;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        final int i = c.maxArea(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 999, 999, 10, 11});
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                ans = Math.max(ans, height[i] * height[j]);
            }
        }
        return ans;
    }
}
