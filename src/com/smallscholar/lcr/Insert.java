package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/11/5 22:19
 * @version 1.0
 * @describe LCR 029. 循环有序列表的插入
 */
public class Insert {

    public Node insert(Node head, int insertVal) {
        Node cur = new Node(insertVal);
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        if (head.next == head) {
            head.next = new Node(insertVal);
            head.next.next = head;
            return head;
        }

        Node slow = head;
        Node fast = head.next;
        while (slow.next != head) {
            // 如果需要插入的值大于当前的, 小于下一个, 那么这两个节点直接肯定就是一个插入的位置
            if (slow.val <= insertVal && fast.val >= insertVal) {
                break;
            }
            if (slow.val > fast.val) {
                if (insertVal > slow.val || insertVal < fast.val) {
                    break;
                }
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = cur;
        cur.next = fast;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
//        Node node2 = new Node(3);
//        Node node3 = new Node(4);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node1;
        node1.next = node1;

        new Insert().insert(node1, 0);

    }

}
