package com.smallscholar.normalPractice.may;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 18:56
 * @describe  判断一个链表是否为回文
 * 先使用一个list保存链表的所有元素, 然后遍历一半进行判断, 如果相同就是,反之就不是
 */
public class IsPail {

    public boolean isPail (ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        boolean res = true;
        for (int i = 0; i < (list.size() - 1) / 2; i++) {
            if (list.get(i) != (int)list.get(list.size() - i - 1)) {
                res = false;
                break;
            }
        }
        return res;
    }

}
