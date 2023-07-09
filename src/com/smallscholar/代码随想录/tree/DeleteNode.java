package com.smallscholar.代码随想录.tree;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 21:20
 * @describe 450. 删除二叉搜索树中的节点
 * test
 */
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else{
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 如果当前节点的左右子树都不为空, 找到当前节点的右子树的最左子树, 使这个节点成为删除后的新的根
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            // 删除右边值等于successor.val的节点
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
    }

}
