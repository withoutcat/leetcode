import ListNode.makeNode
import kotlin.test.Test
import kotlin.test.assertContentEquals

class MergeKLists {
    @Test
    fun mergeKListsTest() {
        // 输入：lists = [[1,4,5],[1,3,4],[2,6]]
        // 输出：[1,1,2,3,4,4,5,6]
        val lists = arrayOf(
            makeNode(1, 4, 5),
            makeNode(1, 3, 4),
            makeNode(2, 6)
        )

        val node = mergeKLists(lists)
        val nodeList = readNode(node)
        assertContentEquals(listOf(1, 1, 2, 3, 4, 4, 5, 6), nodeList)
        // [[2],[],[-1]] 这个用例没过
    }

    private fun readNode(head: ListNode?): List<Int> {
        val res = mutableListOf<Int>()
        var node: ListNode? = head
        while (node != null) {
            res.add(node.`val`)
            node = node.next
        }
        return res
    }
}

