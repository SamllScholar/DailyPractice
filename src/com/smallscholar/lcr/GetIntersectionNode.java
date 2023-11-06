package com.smallscholar.lcr;

import java.awt.image.LookupOp;

/**
 * @author smallscholar
 * @date 2023/11/5 20:12
 * @version 1.0
 * @describe LCR 023. 相交链表
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        int countA = 0;
        ListNode tempB = headB;
        int countB = 0;

        while (tempA.next != null) {
            countA += 1;
            tempA = tempA.next;
        }
        while (tempB.next != null) {
            countB += 1;
            tempB = tempB.next;
        }
        if (tempB != tempA) {
            return null;
        }

        int n = Math.abs(countA - countB);
        ListNode longNode = countA >= countB ? headA : headB;
        ListNode shortNode = longNode == headA ? headB : headA;

        for (int i = 0; i < n; i++) {
            longNode = longNode.next;
        }

        while (longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return longNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node7;
        node7.next = node8;
        node8.next = node3;
        ListNode intersectionNode = new GetIntersectionNode().getIntersectionNode(node1, node6);

        System.out.println(intersectionNode);

    }

}
