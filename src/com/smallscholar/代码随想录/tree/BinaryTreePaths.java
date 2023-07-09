package com.smallscholar.代码随想录.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 14:30
 * @describe ...
 */
public class BinaryTreePaths {

    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }
        sb.append("->");
        String temp = sb.toString();
        dfs(root.left, sb);
        dfs(root.right, new StringBuilder(temp));
    }

}
