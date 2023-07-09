package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 15:26
 * @describe 链表中倒数最后k个结点
 * 特别需要考虑, 当k的长度大于链表的长度的时候怎么办, 当k的长度为0的时候怎办
 * 把这两种特殊的情况考虑到然后使用双指针这个问题就迎刃而解了
 */
public class FindKthToTail {

    public ListNode findKthToTail (ListNode pHead, int k) {
        if (k == 0) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && k - 1 > 0) {
            fast = fast.next;
            k -= 1;
        }
        // 如果fast直接指向了null, 证明当前的k大于链表的长度, 所以直接返回空就可以了
        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode kthToTail = new FindKthToTail().findKthToTail(node1, 0);
        System.out.println(kthToTail.toString());
    }

}
