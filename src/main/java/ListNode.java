public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode makeNode(int... list) {
        ListNode head = null;
        ListNode node = null;
        for (int val : list) {
            if (head == null) {
                head = new ListNode(val);
                node = head;
            } else {
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        return head;
    }
}

