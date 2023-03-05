import java.util.*

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dataMap = TreeMap<Int, Int>()
    fun plus(key: Int) {
        dataMap[key] = (dataMap[key] ?: 0) + 1
    }
    // 统计所有元素的数量
    var count = 0
    lists.forEach {
        var tmpNode: ListNode? = it
        while (tmpNode != null) {
            plus(tmpNode.`val`)
            tmpNode = tmpNode.next
            count++
        }
    }
    // 遍历输出结果
    var node: ListNode? = null
    var head: ListNode? = null
    dataMap.forEach {
        // 如果i重复出现就链接起来
        for (j in 0 until it.value) {
            node = if (head == null) {
                head = ListNode(it.key)
                head
            } else {
                node?.let { n ->
                    n.next = ListNode(it.key)
                    n.next
                }
            }
        }
    }
    return head
}