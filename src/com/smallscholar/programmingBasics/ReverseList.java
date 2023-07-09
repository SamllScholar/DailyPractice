package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 1:34
 * @describe 编程基础第三十一题: 206. 反转链表
 */
public class ReverseList {

    /**
     * 翻转链表的基础
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 进行链表的翻转,把后一个元素指向前一个, 因为第一个的成为最后一个后, 下一个节点是null, 所以pre从null开始
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

}
