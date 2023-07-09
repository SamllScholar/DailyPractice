package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 13:12
 * 链表内指定区间反转: 如果不要求空间复杂度,直接使用stack数据结构是一个非常好的选择
 */
public class ReverseBetween {

    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 定义两个快慢指针, 通过快慢指针进行链表的反转
        ListNode slow = pre;
        ListNode fast = head;
        for (int i = 1; i < m; i++) {
            slow = slow.next;
            fast = fast.next;
        }

        /**
         * 这是一个非常核心的知识点, 如果涉及到链表翻转一定会有下面的这几行代码
         * slow: 永远指向反转链表的最后一个节点, 也就是反转后的第一个节点, 随着遍历的进行这个节点值会一直进行更新
         * fast: 指向需要进行翻转的节点
         * temp: 需要进行翻转的节点,这个节点没遍历一次就需要指向fast一次通过这个操作进行链表的反转
         */
        for (int i = 0; i < n - m; i++) {
            ListNode temp = fast.next;
            fast.next = temp.next;
            temp.next = slow.next;
            slow.next = temp;
        }

        return pre.next;
    }

}
