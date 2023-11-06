package com.smallscholar.lcr;

import com.smallscholar.normalPractice.may.Temp;

/**
 * @author smallscholar
 * @date 2023/11/5 20:28
 * @version 1.0
 * @describe LCR 024. 反转链表
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;

        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return pre.next;
    }

}
