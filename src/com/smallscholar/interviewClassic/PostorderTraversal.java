package com.smallscholar.interviewClassic;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 10:03
 * @describe 面试经典第十七题; 145. 二叉树的后序遍历
 */
public class PostorderTraversal {

    List<Integer> res = new ArrayList<>();

    /**
     * 二叉树的先序遍历 --> 递归的方法
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        return res;
    }

    /**
     * 二叉树是的后序遍历 --> 递归的方法
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    /**
     * 二叉树的中序遍历 --> 递归的方法
     *
     * @param root
     * @return
     */
    public List<Integer> curOrderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        curOrderTraversal(root.left);
        res.add(root.val);
        curOrderTraversal(root.right);
        return res;
    }

    /**
     * 二叉树的先序遍历 --> 通过非递归的方法
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalByStack(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

        return res;
    }

    /**
     * 二叉树的后序遍历 --> 非递归的方法
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversalByStack(TreeNode root) {
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> temp = new ArrayDeque<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode cur = stack.pop();
            temp.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }

        while (temp.size() > 0) {
            res.add(temp.pop().val);
        }

        return res;
    }

    /**
     * 二叉树的中序遍历 --> 非递归的方式,向对于两个, 这个是最难想的
     * @param root
     * @return
     */
    public List<Integer> curOrderTraversalByStack(TreeNode root) {
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || stack.size() > 0) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

    /**
     * 广度遍历 --> 使用队列的思想
     * @param root
     * @return
     */
    public List<Integer> widthOrderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            res.add(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        return res;
    }

}
