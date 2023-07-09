package com.smallscholar.normalPractice.may;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 12:53
 * 反转链表
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre;
        ListNode fast = head;
        while (fast.next != null) {
            ListNode temp = fast.next;
            fast.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }
        return pre.next;
    }

    /**
     * 使用栈的方式进行翻转
     * @param head
     * @return
     */
    public ListNode ReverseListForStack(ListNode head) {
        if (head == null) {
            return head;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = stack.poll();
        pre.next = cur;
        while (stack.size() > 0) {
            cur.next = stack.poll();
            cur = cur.next;
        }
        cur.next = null;

        return pre.next;
    }

}
