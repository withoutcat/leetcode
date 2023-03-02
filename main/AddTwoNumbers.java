public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l11 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);

        AddTwoNumbers a = new AddTwoNumbers();
        final ListNode listNode = a.addTwoNumbers(l11, l21);
        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        if (l1.next == null && l2.next == null && l1.val == 0 && l2.val == 0)
            return listNode;

        ListNode headNode = listNode;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;

            int thisVal = listNode.val + val1 + val2;
            if (thisVal >= 10) {
                listNode.val = thisVal % 10;
                listNode.next = new ListNode(1);
            } else {
                listNode.val = thisVal;
                if (l1 == null && l2 == null)
                    break;
                listNode.next = new ListNode();
            }

            listNode = listNode.next;
        }

        return headNode;
    }
}
