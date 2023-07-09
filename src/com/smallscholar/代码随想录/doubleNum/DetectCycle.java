package com.smallscholar.代码随想录.doubleNum;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:06
 * @describe 142. 环形链表 II
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode flow = head.next;
        ListNode fast = head.next.next;

        while (flow != fast && fast != null && fast.next != null) {
            flow = flow.next;
            fast = fast.next.next;
        }

        if (flow != fast) {
            return null;
        }

        fast = head;
        while (fast != flow) {
            flow = flow.next;
            fast = fast.next;
        }

        return fast;
    }

}
