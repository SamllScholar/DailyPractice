package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 15:46
 * @describe 删除链表的倒数第n个节点
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && n > 0) {
            fast = fast.next;
            n -= 1;
        }
        // 如果要删除的节点就是第一个节点需要特殊的进行判断, 直接返回第二个节点的位置就可以了
        if (fast == null) {
            return pre.next.next;
        }
        // 如果没有执行这一步说明,在前面fast指向的就已经是null, 所以当前就要删除第一个节点, 直接返回第二个节点就可以了
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除执行的节点:指定的节点就是当前的slow指向的下一个节点
        slow.next = slow.next.next;

        return pre.next;
    }

}
