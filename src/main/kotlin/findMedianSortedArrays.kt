/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 * @param nums1
 * @param nums2
 * @return
 */
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var j = 0
    var k = 0
    val res = mutableListOf<Int>()
    while (true) {
        // 正常比较大小, 取小的值, 并且把该值对应的下标向右移动
        if (j < nums1.size && k < nums2.size) {
            if (nums1[j] < nums2[k]) {
                res.add(nums1[j])
                j++
            } else if (nums1[j] == nums2[k]) {
                res.add(nums1[j])
                res.add(nums2[k])
                j++
                k++
            } else {
                res.add(nums2[k])
                k++
            }
        } else if (j < nums1.size) { // 如果nums2越界,那么无需比较直接取nums1的值
            res.add(nums1[j])
            j++
        } else if (k < nums2.size) { // 如果nums1越界,那么无需比较直接取nums2的值
            res.add(nums2[k])
            k++
        } else break // 如果都越界,遍历结束
    }

    if (res.size == 1) return res.first().toDouble()
    // 如果是奇数可以直接返回
    if (res.size % 2 != 0) return res[res.size / 2].toDouble()
    // 如果是偶数,那么取该数和左边数的平均数
    return (res[res.size / 2 - 1] + res[res.size / 2]) / 2.0
}


fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    val len = m + n
    var left = -1
    var right = -1
    var aStart = 0
    var bStart = 0
    for (i in 0..len / 2) {
        left = right
        if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
            right = nums1[aStart++]
        } else {
            right = nums2[bStart++]
        }
    }
    if (len % 2 == 0) {
        return (left + right) / 2.0
    } else {
        return right * 1.0
    }
}

fun main() {
    println(
        findMedianSortedArrays(
            arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4).toIntArray(),
            arrayOf(1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4).toIntArray()
        )
    )
}