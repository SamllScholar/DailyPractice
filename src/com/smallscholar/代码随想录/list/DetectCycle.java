package com.smallscholar.代码随想录.list;

import java.nio.file.Path;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 15:56
 * @describe ...
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode flow = head;
        ListNode fast = head.next;

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
