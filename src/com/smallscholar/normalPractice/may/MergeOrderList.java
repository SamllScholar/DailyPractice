package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 14:28
 * @describe 合并两个排序的链表
 */
public class MergeOrderList {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode pre = new ListNode(-1);
        pre.next = list1.val > list2.val ? list2 : list1;
        ListNode cur = pre;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = list1 == null ? list2 : list1;

        return pre.next;
    }

}
