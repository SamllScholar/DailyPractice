package com.smallscholar.代码随想录.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 18:01
 * @describe 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTreeByPre {

    // 确定当前的根节点的值
    int[] preorder;
    // 确定当前的左右子树的范围
    int[] inorder;
    // 快速定位范围
    HashMap<Integer, Integer> map = new HashMap<>();
    // 当前根节点的索引
    int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        preIndex = 0;
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }

        return build(0, index - 1);
    }

    public TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        // 左右子树的分解点
        Integer index = map.get(val);
        root.left = build(start, index - 1);
        root.right = build(index + 1, end);

        return root;
    }

}
