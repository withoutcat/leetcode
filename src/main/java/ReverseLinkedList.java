public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.makeNode(1, 2, 3, 4, 5);
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode newHead = r.reverseList(head);
        System.out.println(newHead);
    }

    // https://leetcode.cn/problems/reverse-linked-list/

    public ListNode reverseList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode node = head.next.next;
            ListNode tail = head;
            head = head.next;
            head.next = tail;
            tail.next = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = head;
                head = node;
                node = next;
            }
        }
        return head;
    }


}
