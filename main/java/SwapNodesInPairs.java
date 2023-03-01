package java;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        // ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        // n3.next = n4;
        SwapNodesInPairs s = new SwapNodesInPairs();
        final ListNode listNode = s.swapPairs(n1);
        System.out.println(listNode);

    }

    public ListNode swapPairs(ListNode head) {
        // 搞个头
        ListNode ans = null;
        if (head != null)
            ans = head.next;
        if (ans == null)
            return head;
        ListNode pre = null;
        // 交换
        while (head != null) {
            ListNode next = head.next;
            if (next == null)
                break;
            if (pre != null)
                pre.next = head.next;
            head.next = next.next;
            next.next = head;
            pre = head;
            head = head.next;
        }
        return ans;
    }
}
