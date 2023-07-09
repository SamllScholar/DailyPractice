package com.smallscholar.代码随想录.doubleNum;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:00
 * @describe 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        int count = 0;

        while (count < n) {
            head = head.next;
            count += 1;
        }

        while (head != null) {
            cur = cur.next;
            head = head.next;
        }

        cur.next = cur.next.next;

        return pre.next;
    }

}
