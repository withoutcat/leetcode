var head: ListNode? = null
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    var currentNode: ListNode? = null

    lists.forEach {
        it?.let {
            while (currentNode != null) {
                // 没有头,先初始化
                if (head == null) {
                    head = it
                    currentNode = head
                } else {
                    // 遍历头找到合适的位置


                    // 每次都要更新头,始终保持他是最小的
                }
            }
        }
    }

    return head
}

/**
 * 如果[inputNode]的值处于[this]和[this].next的值之间,那么就插入
 *
 * @param inputNode
 * @return true表示插入成功,false表示[inputNode]的值太大,不做任何处理
 */
private fun ListNode.insert(inputNode: ListNode): Boolean {
    return (inputNode.`val` >= this.`val` && inputNode.`val` <= this.next.`val`).also {
        val next = this.next
        this.next = inputNode
        inputNode.next = next
    }
}

private fun iterateHead(inputNode: ListNode) {

}