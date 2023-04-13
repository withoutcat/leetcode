import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;

        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;

        LinkedListCycleII llc = new LinkedListCycleII();
        String result;
        if (llc.detectCycle(node) == null) result = "null";
        else result = String.valueOf(node.val);
        System.out.println(result);
    }

    public ListNode detectCycle(ListNode head) {
        // 虽然题中没有给出节点值是否是唯一的，但是先假定是唯一的
        HashMap<Integer, HashSet<ListNode>> map = new HashMap<>();
        while (head != null) {
            int val = head.val;
            HashSet<ListNode> set = map.computeIfAbsent(val, k -> new HashSet<>());
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
