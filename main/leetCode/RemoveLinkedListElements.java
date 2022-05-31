package leetCode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements r = new RemoveLinkedListElements();
        var head = ListNode.nodeFactory(new int[]{6,6,1,6, 6});
        var theHead = r.removeElements(head, 6);
        System.out.println(theHead);

    }

    public ListNode removeElements(ListNode head, int val) {
        // 添加虚拟头节点
        ListNode mockNode = new ListNode(-1, head);
        ListNode preNode = mockNode;
        ListNode thisNode = head;
        while (thisNode != null) {
            if (thisNode.val == val) {
                preNode.next = thisNode.next;
            } else {
                preNode = thisNode;
            }
            thisNode = thisNode.next;
        }
        return mockNode.next;
    }
}
