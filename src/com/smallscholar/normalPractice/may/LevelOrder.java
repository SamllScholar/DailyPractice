package com.smallscholar.normalPractice.may;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/15 10:06
 * @describe 二叉树的层序遍历:也就是传统意义上的广度遍历
 * java中的数据结构例如: 栈, 队列不可以直接判断是否为空, 因为一定不为空, 可以使用isEmpty或者使用size() > 0进行判断
 * 在网上看到的思路: 在每次遍历的时候确定一下queue的size,然后使用一个for循环就循环size下, 这样就可以保证值取出当前层的数据
 *
 */
public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrderFromNet(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
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
            res.add(new ArrayList<>(temp));
        }

        return res;
    }

    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int target = -11111111;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(new TreeNode(target));

        while (queue.size() > 0) {
            if (queue.peek().val == target) {
                queue.poll();
                if (queue.size() > 0) {
                    queue.add(new TreeNode(target));
                }
                res.add(new ArrayList<>(temp));
                temp.clear();
                continue;
            }
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> arrayLists = new LevelOrder().levelOrder(root);
        System.out.println(arrayLists.toString());
    }

}
