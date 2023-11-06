package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/11/5 20:00
 * @version 1.0
 * @describe LCR 022. 环形链表 II
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            slow = slow.next;

            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }

        }

        return null;
    }


}
