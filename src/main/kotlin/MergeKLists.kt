fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val dataMap = LinkedHashMap<Int, Int>()
    // 统计所有元素的数量
    var count = 0
    lists.forEach {
        var tmpNode: ListNode? = it
        while (tmpNode != null) {
            dataMap[tmpNode.`val`] =
                if (dataMap.contains(tmpNode.`val`)) dataMap[tmpNode.`val`]!! + 1
                else 1
            tmpNode = tmpNode.next
            count++
        }
    }
    // 遍历输出结果
    var node: ListNode? = null
    var head: ListNode? = null
    // dataMap的key无法保证自然排序，如果使用treeMap虽然能保证有序，但本质上就是暴力解了，因为每次插入元素时间复杂度都是O(logn)
    // 我认为这里直接从0开始按升序遍历
    var i = 0
    while (count > 0) {
        dataMap[i]?.let { `val` ->
            // 如果i重复出现就链接起来
            for (j in 0 until `val`) {
                node = if (head == null) {
                    head = ListNode(i)
                    head
                } else {
                    node?.let { n ->
                        n.next = ListNode(i)
                        n.next
                    }
                }
            }
            count -= `val`
        }
        i++
    }
    return head
}