import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] properties = new int[][]{
                new int[]{7, 9},
                new int[]{10, 7},
                new int[]{6, 9},
                new int[]{10, 4},
                new int[]{7, 5},
                new int[]{7, 10},
        };
        solution.numberOfWeakCharacters1(properties);

    }

    // public int numberOfWeakCharacters(int[][] properties) {
    //     // 构建倒叙treemap
    //     TreeMap<Integer, ArrayList<Integer>> sortMap = new TreeMap<>(Comparator.reverseOrder());
    //     for (int[] p : properties) {
    //         int attack = p[0];
    //         int defense = p[1];
    //         // 先看map里有没有这个攻击力
    //         if (sortMap.containsKey(attack)) {
    //             // 如果有这个攻击力，则把防御力添加到arr里
    //             sortMap.get(attack).add(defense);
    //             continue;
    //         }
    //         // 如果有没有则新增一条
    //         ArrayList<Integer> defenseList = new ArrayList<>();
    //         defenseList.add(defense);
    //         // 攻击力做key
    //         sortMap.put(attack, defenseList);
    //     }
    //
    //     final Collection<ArrayList<Integer>> values = sortMap.values();
    //     int count = 0;
    //     //第一个key就是最大攻击力，只要找出所有防御力比他小的元素，统计即可
    //     int maxDefense = 0;
    //     for (ArrayList<Integer> defenseList : values) {
    //         int thisMax = Collections.max(defenseList);
    //
    //         // 第一个是最高攻击力，相同攻击力无需比较防御力，直接跳过
    //         if (maxDefense == 0) {
    //             maxDefense = thisMax;
    //             continue;
    //         }
    //
    //         // 开始找所有的弱角色
    //         for (Integer defenseVal : defenseList)
    //             if (defenseVal < maxDefense)
    //                 count++;
    //
    //         // 每次都要更新最大防御力，因为攻击力一定是依次减弱的，但是防御力可能出现更高的。
    //         maxDefense = maxDefense < thisMax ? thisMax : maxDefense;
    //     }
    //
    //     return count;
    // }

    public int numberOfWeakCharacters1(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        int count = 0;


        int maxDefense = 0;
        for (int[] p : properties) {
            if (p[1] < maxDefense)
                count++;
            else
                maxDefense = p[1];
        }
        return 0;
    }
}
