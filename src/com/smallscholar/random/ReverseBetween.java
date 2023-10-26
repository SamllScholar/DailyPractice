package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/22 23:40
 * @version 1.0
 * @describe ...
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode node = pre;
        ListNode nodePre;

        for (int i = 0; i < left - 1; i++) {
            node = node.next;
        }

        /**
         * lc弱智,这里是对的
         */
        // while (node.next.val != left) {
        // node = node.next;
        //  }
        nodePre = node;
        node = node.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = node.next;
            node.next = temp.next;
            temp.next = nodePre.next;
            nodePre.next = temp;
        }


        return pre.next;
    }

    public static void main(String[] args) {
        ListNode list01 = new ListNode(1);
        ListNode list02 = new ListNode(2);
        ListNode list03 = new ListNode(3);
        ListNode list04 = new ListNode(4);
        ListNode list05 = new ListNode(5);
        list01.next = list02;
        list02.next = list03;
        list03.next = list04;
        list04.next = list05;

        ListNode listNode = new ReverseBetween().reverseBetween(list01, 2, 4);

        System.out.println(listNode);

    }

}
