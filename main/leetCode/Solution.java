package leetCode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] properties = new int[][]{
                new int[]{1, 5},
                new int[]{10, 4},
                new int[]{4, 3},
                new int[]{4, 7},
                new int[]{4, 6},
                new int[]{4, 4},
                new int[]{4, 8},
                new int[]{4, 5},


                new int[]{5, 8},
                new int[]{5, 6},
                new int[]{5, 4},
                new int[]{5, 7},
                new int[]{5, 5},
                new int[]{99, 99},
                new int[]{1, 1},};
        solution.numberOfWeakCharacters(properties);

    }

    public int numberOfWeakCharacters(int[][] properties) {

        // 构建倒叙treemap
        TreeMap<Integer, ArrayList<Integer>> sortMap = new TreeMap<>(Comparator.reverseOrder());
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

        final Collection<ArrayList<Integer>> values = sortMap.values();
        int count = 0;
        //第一个key就是最大攻击力，只要找出所有防御力比他小的元素，统计即可
        int maxDefense = 0;
        for (ArrayList<Integer> defenseList : values) {
            // 第一个元素找出最大防御力
            if (maxDefense == 0) maxDefense = Collections.max(defenseList);

            // 开始找所有的弱角色
            for (Integer defenseVal : defenseList)
                if (defenseVal < maxDefense) count++;

        }

        return count;
    }


}
