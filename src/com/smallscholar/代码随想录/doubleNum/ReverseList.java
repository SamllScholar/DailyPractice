package com.smallscholar.代码随想录.doubleNum;


/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 23:55
 * @describe 206. 反转链表
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
