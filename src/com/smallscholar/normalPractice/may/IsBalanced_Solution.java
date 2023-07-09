package com.smallscholar.normalPractice.may;

import javax.swing.plaf.multi.MultiTableHeaderUI;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 23:00
 * @describe ...
 */
public class IsBalanced_Solution {

    public static class Node {
        int depth;
        boolean balance;

        public Node(int depth, boolean balance) {
            this.depth = depth;
            this.balance = balance;
        }
    }

    public boolean isBalanced_Solution(TreeNode root) {
        return isBalance(root, 1).balance;
    }

    public Node isBalance(TreeNode root, int depth) {
        if (root == null) {
            return new Node(0, true);
        }
        if (root.right == null && root.left == null) {
            return new Node(1, true);
        }

        Node leftNode = isBalance(root.left, depth);
        Node rightNode = isBalance(root.right, depth);
        depth = Math.max(leftNode.depth, rightNode.depth) + 1;
        boolean balance = leftNode.balance && rightNode.balance && Math.abs(leftNode.depth - rightNode.depth) <= 1;
        return new Node(depth, balance);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        boolean balancedSolution = new IsBalanced_Solution().isBalanced_Solution(root);
        System.out.println(balancedSolution);
    }
}
