package com.smallscholar.programmingBasics;

import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 1:57
 * @describe 编程基础第三十三题: 445. 两数相加 II
 * 链表的开始时大数,显然不能直接进行相加
 * 思路一: 可以先对链表进行翻转, 这样两个链表的小的部分就在链表的开始了,就和经典的相加问题的解法一样了
 * 思路二: 可以使用栈保存两个链表的节点, 那么栈顶的元素就是两个链表的最后两个节点
 */
public class AddTwoNumbersTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        ListNode res = null;
        int carry = 0;
        while (s1.size() > 0 || s2.size() > 0) {
            int x = s1.size() > 0 ? s1.pop().val : 0;
            int y = s2.size() > 0 ? s2.pop().val : 0;
            int sum = x + y + carry;
            ListNode temp = new ListNode(sum % 10);
            carry = sum / 10;
            temp.next = res;
            res = temp;
        }

        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = res;
            res = temp;
        }

        return res;
    }

}
