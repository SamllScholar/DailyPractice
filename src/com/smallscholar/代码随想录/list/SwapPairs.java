package com.smallscholar.代码随想录.list;

import java.util.Currency;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 15:17
 * @describe 24. 两两交换链表中的节点
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next.next.next;
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            cur.next.next = temp;
            temp.next = next;
            cur = cur.next.next;
        }

        return pre.next;
    }

}
