package dataStructure.tree;

import lombok.val;

import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private Integer val;

    public TreeNode(Integer val){
        this.val = val;
    }

    static TreeNode initTreeNode(){
        TreeNode treeNode1 = new TreeNode(12);
        TreeNode treeNode11 = new TreeNode(5);
        TreeNode treeNode12 = new TreeNode(6);
        TreeNode treeNode111 = new TreeNode(4);
        TreeNode treeNode112 = new TreeNode(9);
        TreeNode treeNode1112 = new TreeNode(2);
        TreeNode treeNode121 = new TreeNode(15);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode12.left = treeNode121;

        treeNode11.left = treeNode111;
        treeNode11.right = treeNode112;

        treeNode111.right = treeNode1112;
        //        12
        //     /      \
        //    5        6
        //  /   \     /
        // 4     9   15
        //  \
        //   2
        return treeNode1;
    }

    public static void main(String[] args) {
        TreeNode root = initTreeNode();
        //前序遍历-递归
        preOrderRecursion(root);
        System.out.print("\n");
        //前序遍历-非递归
        preOrderNoRecursion(root);
        System.out.print("\n");
        //中序遍历-递归
        midOrderRecursion(root);
        System.out.print("\n");
        //中序遍历-非递归
        midOrderNoRecursion(root);
        System.out.print("\n");
        //后序遍历-递归
        postOrderRecursion(root);
        System.out.print("\n");
        //后序遍历-非递归
        postOrderNoRecursion(root);
        System.out.print("\n");
        // 层次遍历
        levelTraverse(root);
        System.out.print("\n");
        // 深度优先遍历
        depthOrderTraverse(root);
    }

    private static void depthOrderTraverse(TreeNode root) {
        if(root == null){
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.print(pop.val + " ");
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
    }

    private static void levelTraverse(TreeNode root) {
        if(root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
    }

    private static void postOrderNoRecursion(TreeNode root) {
        //todo 还未实现
    }

    private static void midOrderNoRecursion(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                TreeNode poll = stack.poll();
                System.out.print(poll.val + " ");
                curNode = poll.right;
            }
        }
    }

    private static void preOrderNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                System.out.print(curNode.val + " ");
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                TreeNode node = stack.pop();
                curNode = node.right;
            }
        }
    }

    private static void postOrderRecursion(TreeNode node) {
        if(node != null){
            postOrderRecursion(node.left);
            postOrderRecursion(node.right);
            System.out.print(node.val+" ");
        }
    }

    private static void midOrderRecursion(TreeNode node) {
        if(node != null){
            midOrderRecursion(node.left);
            System.out.print(node.val+" ");
            midOrderRecursion(node.right);
        }
    }

    private static void preOrderRecursion(TreeNode node) {
        if(node != null){
            System.out.print(node.val+" ");
            preOrderRecursion(node.left);
            preOrderRecursion(node.right);
        }
    }

}
