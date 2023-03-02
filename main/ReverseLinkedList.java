public class ReverseLinkedList {
    public static void main(String[] args) {
        var head = ListNode.nodeFactory(new int[]{1, 2, 3, 4, 5});
        ReverseLinkedList r = new ReverseLinkedList();
        var newHead = r.reverseList(head);
        System.out.println(newHead);
    }

    // https://leetcode.cn/problems/reverse-linked-list/

    public ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            var node = head.next.next;
            var tail = head;
            head = head.next;
            head.next = tail;
            tail.next = null;
            while (node != null) {
                var next = node.next;
                node.next = head;
                head = node;
                node = next;
            }
        }
        return head;
    }


}
