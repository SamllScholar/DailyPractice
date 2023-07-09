package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 14:00
 * @describe 链表中的节点每k个一组翻转
 * tips: 在链表中的循环的次数往往比正常次数少一个
 */
public class ReverseKGroup {


    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 计算可以分成多少组进行翻转, 如果最后一组不足就不进行分组
        int count = 0;
        while (head != null) {
            count += 1;
            head = head.next;
        }
        count = count / k;


        if (count > 0) {
            head = pre.next;
            ListNode slow = pre;
            ListNode fast = head;
            // 外层是需要进行分组翻转的次数
            for (int i = 0; i < count; i++) {
                // 控制本次的翻转的循环次数, 循环里面还是那个经典的代码
                for (int j = 1; j < k; j++) {
                    ListNode temp = fast.next;
                    fast.next = temp.next;
                    temp.next = slow.next;
                    slow.next = temp;
                }
                // 本次翻转完成后,慢指针应该指向本次分组的最后一个(翻转过后本组的第一个元素就是最后一个, 本组的第一个元素
                // 就是fast, 快指针应该指向下次翻转的第一个, 第一个就是当前快指针指向的下一个
                slow = fast;
                fast = fast.next;
            }
        }

        return pre.next;
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
        ListNode node = new ReverseKGroup().reverseKGroup(node1, 2);
        System.out.println(node.toString());
    }
}
