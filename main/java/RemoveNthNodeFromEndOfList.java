package java;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        // r.removeNthFromEnd();
    }

    // 自己想的方法
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     HashMap<Integer, ListNode> map = new HashMap<>();
    //     ListNode headCopy = head;
    //     int nth = 1;
    //     while (head != null) {
    //         map.put(nth, head);
    //         head = head.next;
    //         nth++;
    //     }
    //     ListNode pre = map.get(nth - n - 1);
    //     ListNode next = map.get(nth - n + 1);
    //     if (pre == null) return next;
    //     pre.next = next;
    //     return headCopy;
    // }

    // 抄的递归回溯法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int traverse = traverse(head, n);
        if(traverse == n)
            return head.next;
        return head;
    }

    private int traverse(ListNode node, int n) {
        if(node == null)
            return 0;
        int num = traverse(node.next, n);
        if(num == n)
            node.next = node.next.next;
        return num + 1;
    }

}



