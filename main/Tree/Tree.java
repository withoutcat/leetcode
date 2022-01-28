package Tree;

import java.util.ArrayList;

public class Tree {
    private int value;
    private Tree left;
    private Tree right;

    public Tree(int value) {
        this.value = value;
    }

    public Tree() {

    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }
}

class Test {
    public static void main(String[] args) {
        // 构建二叉树
        Tree head = new Tree(1);
        Tree t2 = new Tree(2);
        Tree t3 = new Tree(3);
        Tree t4 = new Tree(4);
        Tree t5 = new Tree(5);
        Tree t6 = new Tree(6);

        head.setLeft(t2);
        head.setRight(t3);

        t2.setLeft(t4);
        t3.setLeft(t5);
        t3.setRight(t6);

        // 遍历
        Test test = new Test();
        ArrayList<Tree> visitList = new ArrayList<>();
        // 访问头
        test.fetchNode(visitList, head);
        System.out.println(head.getValue());

        while (!visitList.isEmpty()) {
            ArrayList<Tree> tempList = new ArrayList<>();
            for (Tree t : visitList) {
                test.fetchNode(tempList, t);
                // 访问
                System.out.println(t.getValue());
            }
            visitList = tempList;
        }
    }

    // 提取节点
    void fetchNode (ArrayList list, Tree tree) {
        if (tree.getLeft() != null) list.add(tree.getLeft());
        if (tree.getRight() != null ) list.add(tree.getRight());
    }
}
