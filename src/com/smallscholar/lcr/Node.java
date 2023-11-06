package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/11/5 21:14
 * @version 1.0
 * @describe 双向链表的数据结构
 */
public class Node {

    int val;
    Node prev;
    Node next;
    Node child;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
}
