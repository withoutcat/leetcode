package leetCode;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] properties = new int[][]{
                new int[]{1, 5},
                new int[]{10, 4},
                new int[]{4, 3},
                new int[]{4, 4},
                new int[]{4, 5},
                new int[]{4, 6},
                new int[]{4, 7},
                new int[]{4, 8},
                new int[]{5, 4},
                new int[]{5, 5},
                new int[]{5, 6},
                new int[]{5, 7},
                new int[]{5, 8},
                new int[]{99, 99},
                new int[]{1, 1},
        };
        solution.numberOfWeakCharacters(properties);

    }

    public int numberOfWeakCharacters(int[][] properties) {

        // 构建treemap
        TreeMap<Integer, ArrayList<Integer>> sortMap = new TreeMap<>();
        for (int[] p : properties) {
            int attack = p[0];
            int defense = p[1];
            // 先看map里有没有这个攻击力
            if (sortMap.containsKey(attack)) {
                // 如果有这个攻击力，则把防御力添加到arr里
                sortMap.get(attack).add(defense);
                continue;
            }
            // 如果有没有则新增一条
            ArrayList<Integer> defenseList = new ArrayList<>();
            defenseList.add(defense);
            // 攻击力做key
            sortMap.put(attack, defenseList);
        }

        //遍历treemap，有序
        for (Map.Entry<Integer, ArrayList<Integer>> entry : sortMap.entrySet()) {

        }



        return 0;
    }


}
