package com.smallscholar.normalPractice.may;

import java.awt.image.CropImageFilter;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 16:38
 * @describe 链表相加(二)
 */
public class AddInList {

    public ListNode addInList (ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int carry = 0;

        while (head1 != null || head2 != null) {
            int num1 = head1 != null ? head1.val : 0;
            int num2 = head2 != null ? head2.val : 0;
            int sum = num1 + num2 + carry;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            carry = sum / 10;

            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return reverse(res.next);

    }

    public ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(7);
        node11.next = node12;
        node12.next = node13;
        ListNode node21 = new ListNode(6);
        ListNode node22 = new ListNode(3);
        node21.next = node22;

        ListNode node = new AddInList().addInList(node11, node21);
        System.out.println(node.toString());
    }

}
