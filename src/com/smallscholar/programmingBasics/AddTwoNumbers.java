package com.smallscholar.programmingBasics;

import com.smallscholar.normalPractice.may.Temp;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 1:45
 * @describe 编程基础第三十二题: 2. 两数相加
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode sum = pre;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int temp = x + y + carry;
            sum.next = new ListNode(temp % 10);
            sum = sum.next;
            carry = temp / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0){
            sum.next = new ListNode(carry);
        }

        return pre.next;
    }

}
