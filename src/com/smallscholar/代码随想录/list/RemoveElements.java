package com.smallscholar.代码随想录.list;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 14:56
 * @describe ...
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode cur = pre;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return pre.next;
    }

}
