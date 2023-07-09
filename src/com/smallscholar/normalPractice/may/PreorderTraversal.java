package com.smallscholar.normalPractice.may;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 9:44
 * @describe 二叉树的前序遍历
 */
public class PreorderTraversal {

    ArrayList<Integer> list = new ArrayList<>();

    public int[] preorderTraversal (TreeNode root) {
        preOrder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        int[] ints = new PreorderTraversal().preorderTraversal(root);
        System.out.println(Arrays.toString(ints));
    }

}
