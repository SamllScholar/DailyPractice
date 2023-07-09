package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 11:58
 * @describe ...
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return isSum(root, sum, 0);
    }

    public boolean isSum(TreeNode root, int sum, int temp) {
        if (root .right == null && root.left == null) {
            return temp + root.val == sum;
        }

        boolean left = false;
        boolean right = false;

        if (root.left != null) {
            left = isSum(root.left, sum, temp + root.val);
        }
        if (root.right != null) {
            right = isSum(root.right, sum, temp + root.val);
        }

        return left || right;

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(11);
//        root.left.right.left = new TreeNode(2);
//        root.left.right.right = new TreeNode(7);
//        root.right = new TreeNode(8);
//        root.right.right = new TreeNode(9);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        boolean b = new HasPathSum().hasPathSum(root, 1);
        System.out.println(b);
    }

}
