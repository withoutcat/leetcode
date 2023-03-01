package java;


public class ZigzagConversion {
    public static void main(String[] args) {
        // String s = "0123456789TettffssenTz";
        String s = "0123456789Tetsff";
        ZigzagConversion z = new ZigzagConversion();
        final String convert = z.convert2(s, 3);
        System.out.println(convert);
    }

    // 思路1 太过于考虑空间复杂，导致代码太烧脑，很难调的通，边界条件太多了
    // public String convert(String s, int numRows) {
    //     /**
    //      * 层中存在于完整列的点被定义为node
    //      * 每层的开头都是完整列中的node开始的
    //      * 根据层数和node，从给定字符串中找到要取得的下标
    //      */
    //     if (1 == numRows) return s;
    //
    //     char[] result = new char[s.length()];
    //     int n = 0;// 顶层
    //     int sEndIndex = s.length() - 1;
    //     int row = 0;
    //
    //     // 结果拼接
    //     for (int i = 0; i < result.length; i++) {
    //         // 获取本次基准节点
    //         int nodeIndex = (numRows - 1) * 2 * row + n;
    //
    //         if (row == 0) {// 每层开头不考虑左右char
    //             result[i] = s.charAt(nodeIndex);
    //             ++row;
    //             continue;
    //         }
    //
    //         // 顶层和底层
    //         if (n == 0 || n == numRows - 1) {
    //             //如果是顶层和底层，只考虑node
    //             if (nodeIndex <= sEndIndex) {
    //                 result[i] = s.charAt(nodeIndex);
    //                 int nextNodeIndex = (numRows - 1) * 2 * (row + 1) + n;
    //                 if (nextNodeIndex <= sEndIndex) {
    //                     ++row;
    //                     continue;
    //                 }
    //             }
    //         } else {
    //             // 中间层按照 左char-node-右char的顺序来拼接
    //             int nodeLeft = nodeIndex - n * 2;
    //             if (nodeLeft <= sEndIndex) {
    //                 result[i] = s.charAt(nodeLeft); // 左
    //                 if (nodeIndex < sEndIndex) {
    //                     result[++i] = s.charAt(nodeIndex); // 中
    //                     int nextNodeIndex = (numRows - 1) * 2 * (row + 1) + n;
    //                     if (nextNodeIndex > sEndIndex) {
    //                         int nodeRight = nextNodeIndex - n * 2;
    //                         if (nodeRight <= sEndIndex)
    //                             result[++i] = s.charAt(nodeRight); //右
    //                     }
    //                 }
    //                 ++i;
    //             }
    //         }
    //
    //         ++n;
    //         row = 0;
    //     }
    //
    //     return String.valueOf(result);
    // }

    // StringBuilder
    public String convert1(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder result = new StringBuilder(s.length());
        for (int n = 0; n < numRows; n++) {
            int nodeIndex = n;
            while (true) {
                // 中间层和非层开头需要考虑左边，即使是出界也要看左边，只是下一次不循环了
                if (n != 0 && n != numRows - 1 && nodeIndex != n) {
                    int nodeLeft = nodeIndex - n * 2;
                    if (nodeLeft >= s.length()) break;
                    result.append(s.charAt(nodeLeft));
                }

                //顶层和底层直接加node
                if (nodeIndex < s.length()) {
                    result.append(s.charAt(nodeIndex));
                    nodeIndex += (numRows - 1) * 2;
                } else break;
            }
        }

        return result.toString();
    }

    // 数组
    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        char[] result = new char[s.length()];
        int resultIndex = 0;
        for (int n = 0; n < numRows; n++) {
            int nodeIndex = n;
            while (true) {
                // 中间层和非层开头需要考虑左边，即使是出界也要看左边，只是下一次不循环了
                if (n != 0 && n != numRows - 1 && nodeIndex != n) {
                    int nodeLeft = nodeIndex - n * 2;
                    if (nodeLeft >= s.length()) break;
                    result[resultIndex] = s.charAt(nodeLeft);
                    ++resultIndex;
                }

                //顶层和底层直接加node
                if (nodeIndex < s.length()) {
                    result[resultIndex] = s.charAt(nodeIndex);
                    ++resultIndex;
                    nodeIndex += (numRows - 1) * 2;
                } else break;
            }
        }

        return String.valueOf(result);
    }
}
