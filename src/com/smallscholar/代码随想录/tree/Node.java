package com.smallscholar.代码随想录.tree;

import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 12:50
 * @describe ...
 */
public class Node {

    int val;
    List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
