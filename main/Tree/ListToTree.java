package Tree;

import java.util.ArrayList;

public class ListToTree {
    public static void main(String[] args) {
        int[] bigArr = new int[]{1, 2, 3, 4, 6, 7, 1, 2, 3, 4, 1, 2, 3};
        int[] smallArr = new int[]{9, 8};

        int[] subArr = findIndex(bigArr, smallArr);
        System.out.println("" + subArr[0] + subArr[1]);
    }

    static int[] findIndex(int[] bigArr, int[] smallArr) {
        int startIndex = 0;
        for (int i = 0; i < bigArr.length - smallArr.length; i++) {
            startIndex = i;
            boolean flag = false;
            if (bigArr[i] == smallArr[0]) {
                for (int j = 0; j < smallArr.length; j++) {
                    if (bigArr[i + j + 1] != smallArr[j]) break;
                }
                flag = true;
            }

            if (flag)
                return new int[]{startIndex, startIndex + smallArr.length - 1};
        }

        return new int[]{0, 0};
    }

}
