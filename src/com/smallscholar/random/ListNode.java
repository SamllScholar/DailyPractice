package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/22 23:18
 * @version 1.0
 * @describe 单链表
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
