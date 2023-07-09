package com.smallscholar.代码随想录.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 15:45
 * @describe 513. 找树左下角的值
 */
public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    ans = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return ans;
    }

}
