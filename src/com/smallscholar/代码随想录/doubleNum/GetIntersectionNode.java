package com.smallscholar.代码随想录.doubleNum;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:01
 * @describe 面试题 02.07. 链表相交
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur01 = headA;
        ListNode cur02 = headB;
        int len01 = 0;
        int len02 = 0;

        while (cur01 != null) {
            cur01 = cur01.next;
            len01 += 1;
        }
        while (cur02 != null) {
            cur02 = cur02.next;
            len02 += 1;
        }

        cur01 = len01 >= len02 ? headA : headB;
        cur02 = cur01 == headA ? headB : headA;
        int count = Math.abs(len01 - len02);

        while (count > 0) {
            cur01 = cur01.next;
            count -= 1;
        }

        while (cur01 != cur02) {
            cur01 = cur01.next;
            cur02 = cur02.next;
        }

        return cur01;
    }

}
