import java.util.Optional;

class MyLinkedList {
    public Integer val;

    public int size = 0;

    public MyLinkedList pre;

    public MyLinkedList next;

    public MyLinkedList head;

    public MyLinkedList tail;

    public int get(int index) {
        return getNode(index).map(node -> node.val).orElse(-1);
    }

    private Optional<MyLinkedList> getNode(int index) {
        MyLinkedList node = this.head;
        MyLinkedList res = null;
        int count = 0;
        while (node != null) {
            if (count == index) {
                res = node;
                break;
            }
            node = node.next;
            count++;
        }
        return Optional.ofNullable(res);
    }

    private MyLinkedList getTail() {
        return getNode(this.size - 1).get();
    }

    public void addAtHead(int val) {
        init();
        // 在this和next中间插入一个复制节点 next可以是null，没关系
        this.next = new MyLinkedList(this.val, this, this.next);
        // 维护一下头节点
        this.val = val;
        this.size++;
        if (this.size == 1) {
            this.tail = this.next;
        }
        if (this.size > 1) {
            this.next.next.pre = this.next;
        }
    }

    public void addAtTail(int val) {
        init();
        // 直接往后拼接，灰常简单
        this.tail.next = new MyLinkedList(val);
        // 维护一下头信息
        this.size++;
        this.tail.next.pre = this.tail;
        this.tail = this.tail.next;
    }

    private void init() {
        if (this.head == null && this.tail == null) {
            this.size = 1;
            this.head = this;
            this.tail = this;
        }
    }


    // public void addAtIndex(int index, int val) {
    //     if (index <= 0) {
    //         addAtHead(val);
    //         return;
    //     }
    //
    //     if (index >=)
    //         getNode(index).ifPresentOrElse(
    //                 node ->
    //         );
    // }

    public void deleteAtIndex(int index) {

    }

    public MyLinkedList(Integer val) {
        this.val = val;
    }

    public MyLinkedList(Integer val, MyLinkedList pre, MyLinkedList next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */