package com.smallscholar.normalPractice.may;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 10:43
 * @describe 按之型顺序打印二叉树
 */
public class PrintTreeNode {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        int count = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (count % 2 != 0) {
                res.add(new ArrayList<>(temp));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = temp.size() - 1; i >= 0; i--) {
                    list.add(temp.get(i));
                }
                res.add(new ArrayList<>(list));
            }
            count += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = new PrintTreeNode().print(root);
        System.out.println(arrayLists.toString());
    }

}
