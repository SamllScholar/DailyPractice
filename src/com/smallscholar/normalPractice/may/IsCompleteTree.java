package com.smallscholar.normalPractice.may;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 21:15
 * @describe 判断一个树是不是一个完全二叉树
 */
public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                flag = true;
                continue;
            }
            if (flag) {
                return false;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        boolean completeTree = new IsCompleteTree().isCompleteTree(root);
        System.out.println(completeTree);
    }

}
