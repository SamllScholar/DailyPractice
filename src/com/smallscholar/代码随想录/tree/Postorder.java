package com.smallscholar.代码随想录.tree;

import com.smallscholar.normalPractice.may.Temp;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 12:55
 * @describe 590. N 叉树的后序遍历
 */
public class Postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> temp = new Stack<>();
        temp.push(root);

        while (!temp.empty()) {
            Node cur = temp.pop();
            stack.push(cur);
            List<Node> list = cur.children;
            for (Node node : list) {
                temp.push(node);
            }
        }

        while (!stack.empty()) {
            ans.add(stack.pop().val);
        }

        return ans;
    }

}
