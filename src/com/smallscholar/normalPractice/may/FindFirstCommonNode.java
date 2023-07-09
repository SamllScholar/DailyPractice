package com.smallscholar.normalPractice.may;

import com.sun.media.sound.ModelMappedInstrument;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 16:13
 * @describe 两个链表的第一个公共结点
 * 思路: 先遍历一遍两个链表, 求出来两个链表的长度, 找到长链表和短链表, 长的链表先走 两个链表的长度差,然后两个链表
 * 同时走,边走边遍历, 如果两个两个节点相同那么一定是第一个相交的节点
 */
public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;

        while (temp1 != null) {
            temp1 = temp1.next;
            length1 += 1;
        }
        while (temp2 != null) {
            temp2 = temp2.next;
            length2 += 1;
        }

        ListNode maxLen = length2 > length1 ? pHead2 : pHead1;
        ListNode minLen = maxLen == pHead1 ? pHead2 : pHead1;
        int n = Math.abs(length1 - length2);
        while (n > 0) {
            maxLen = maxLen.next;
            n -= 1;
        }

        while (maxLen != minLen) {
            minLen = minLen.next;
            maxLen = maxLen.next;
        }

        return maxLen;
    }



}
