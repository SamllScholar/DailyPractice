package com.smallscholar.代码随想录.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 12:49
 * @describe 589. N 叉树的前序遍历
 */
public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node cur = stack.pop();
            ans.add(cur.val);
            List<Node> list = cur.children;
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        return ans;
    }

}
