public class IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 遍历A链表，倒数写入缓存链表，
        // 遍历B链表，

        return null;
    }

    private ListNode reverseList(ListNode head) {
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
