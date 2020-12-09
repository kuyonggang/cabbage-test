package dataStructure.tree;

public class SymmetricTree {

    static TreeNode initTreeNode(){
        TreeNode treeNode1 = new TreeNode(12);
        TreeNode treeNode11 = new TreeNode(5);
        TreeNode treeNode12 = new TreeNode(5);
        TreeNode treeNode112 = new TreeNode(15);
        TreeNode treeNode121 = new TreeNode(15);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode12.left = treeNode121;

        treeNode11.right = treeNode112;
        //        12
        //     /      \
        //    5        5
        //     \     /
        //     15   15
        return treeNode1;
    }

    public static void main(String[] args) {
        TreeNode root = initTreeNode();
        System.out.println(isMirror(root, root));
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                 && isMirror(t1.left, t2.right);
    }
}
