public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;

        ConstructStringFromBinaryTree c = new ConstructStringFromBinaryTree();
        System.out.println(c.tree2str(t1));
    }

    public String tree2str(TreeNode root) {
        if (root == null) return null;
        return root.val + packageVal(tree2str(root.left), tree2str(root.right));
    }

    public String packageVal(String left, String right) {
        if (left == null && right == null) return "";
        String leftVal = "(" + (left == null ? "" : left) + ")";
        String rightVal = right == null ? "" : "(" + right + ")";
        return leftVal + rightVal;
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}