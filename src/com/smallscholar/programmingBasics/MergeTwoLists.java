package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 1:25
 * @describe 编程入门第三十题: 21. 合并两个有序链表
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null){
            return list1;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        while (list1 != null && list2 != null) {
            int x = list1.val;
            int y = list2.val;
            if (x <= y) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }

        cur.next = list1 == null ? list2 : list1;
        return pre.next;
    }

}
