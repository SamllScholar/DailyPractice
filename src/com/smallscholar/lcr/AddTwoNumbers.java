package com.smallscholar.lcr;

import java.util.Stack;

/**
 * @author smallscholar
 * @date 2023/11/5 20:32
 * @version 1.0
 * @describe LCR 025. 两数相加 II
 *
 * 这里实现了进阶的挑战, 不翻转链表, 而是使用栈来保存两个链表的节点(当前我下面保存的是节点, 也可以保存节点的值,  这样应该会快一点)
 * 这个方法的弊端就是空间复杂度是(n)
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        // 使用栈来处理两个链表, 这样可以直接操作链表的尾节点
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode tempA = l1;
        ListNode tempB = l2;

        while (tempA != null) {
            stackA.push(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            stackB.push(tempB);
            tempB = tempB.next;
        }

        int carry = 0;

        while (!stackA.isEmpty() || !stackB.isEmpty()) {
            int x = !stackA.isEmpty() ? stackA.pop().val : 0;
            int y = !stackB.isEmpty() ? stackB.pop().val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode temp = new ListNode(sum % 10);
            ListNode node = res.next;
            res.next = temp;
            temp.next = node;
        }

        if (carry != 0) {
            ListNode temp = new ListNode(1);
            ListNode node = res.next;
            res.next = temp;
            temp.next = node;
        }

        return res.next;
    }

}
