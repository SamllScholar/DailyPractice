package com.smallscholar.lcr;

import java.util.List;

/**
 * @author smallscholar
 * @date 2023/11/5 19:47
 * @version 1.0
 * @describe ...
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
