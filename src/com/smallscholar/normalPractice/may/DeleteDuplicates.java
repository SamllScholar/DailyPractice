package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 19:13
 * @describe 删除给出链表中的重复元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        ListNode pre = new ListNode(0), p1 = pre;
        pre.next = head;
        boolean flag = false;
        while (p1.next != null && p1.next.next != null) {
            // p1相当于一个观察者, 看他的下一个和下下个是否一样, 如果一样把flag设置成true,然后
            if (p1.next.val == p1.next.next.val) {
                flag = true;
                p1.next = p1.next.next;
            } else if (flag) {
                flag = false;
                p1.next = p1.next.next;
            } else {
                p1 = p1.next;
            }
        }
        if (flag) {
            p1.next = null;
        }
        return pre.next;
    }

}
