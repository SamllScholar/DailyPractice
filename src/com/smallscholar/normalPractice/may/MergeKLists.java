package com.smallscholar.normalPractice.may;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 14:39
 * @describe 合并k个已排序的链表
 * 实验复杂度要求nlogn这就说明一定要使用进阶的排序算法, 通过题意可以一眼就看出基本就是让用归并排序进行解答
 */
public class MergeKLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0 || lists == null) {
            return null;
        }
        return merge(lists, 0, lists.size() - 1);
    }

    public ListNode merge(ArrayList<ListNode> lists, int left, int right) {
        if (left >= right) {
            return lists.get(left);
        }
        int mid = (left + right) >> 1;

        ListNode node1 = merge(lists, left, mid);
        ListNode node2 = merge(lists, mid + 1, right);

        return sort(node1, node2);
    }

    public ListNode sort(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        ListNode pre = new ListNode(-1);
        pre.next = left.val > right.val ? right : left;
        ListNode cur = pre;

        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.next = right;
                right = right.next;
            } else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }

        cur.next = left == null ? right : left;

        return pre.next;
    }

}
