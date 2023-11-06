package com.smallscholar.lcr;

import com.smallscholar.normalPractice.may.IsPail;

/**
 * @author smallscholar
 * @date 2023/11/5 20:51
 * @version 1.0
 * @describe LCR 027. 回文链表
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length += 1;
            node = node.next;
        }

        int m = length / 2 - 1;
        ListNode pre = head;

        for (int i = 0; i < m; i++) {
            pre = pre.next;
        }
        ListNode next = pre.next;
        while (next != null && next.next != null) {
            ListNode temp = next.next;
            next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        next = pre.next;
        m = length / 2;

        for (int i = 0; i < m; i++) {
            if (next.val != head.val) {
                return false;
            }

            next = next.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;
        boolean r = new IsPalindrome().isPalindrome(node1);

        System.out.println(r);
    }

}
