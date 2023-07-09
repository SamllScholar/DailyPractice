package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 19:04
 * @describe 链表的奇偶重排
 * 我们可以单独构造一个偶链, 在原来的基础上构造奇链
 */
public class OddEvenList {

    public ListNode oddEvenList (ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        while (even != null && even.next != null) {
            // 把下一个指向的偶数变成指向奇数
            odd.next = odd.next.next;
            odd = odd.next;
            // 把下一个指向的奇数变成指向偶数
            even.next = even.next.next;
            even = even.next;
        }
        // 把奇数最后一个节点指向偶数的第一个节点
        odd.next = evenHead;

        return head;
    }

}
