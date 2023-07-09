package com.smallscholar.代码随想录.list;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 15:14
 * @describe ...
 */
class MyLinkedList {

    ListNode pre;
    int length;

    public MyLinkedList() {
        pre = new ListNode(-1);
        length = 0;
    }

    public int get(int index) {
        ListNode cur = pre;
        int count = -1;
        while (cur.next != null && count < index) {
            cur = cur.next;
            count += 1;
        }
        return count == index ? cur.val : -1;
    }

    public void addAtHead(int val) {
        ListNode temp = pre.next;
        ListNode addNode = new ListNode(val);
        pre.next = addNode;
        addNode.next = temp;
        length += 1;
    }

    public void addAtTail(int val) {
        ListNode cur = pre;
        ListNode node = new ListNode(val);
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        length += 1;
    }

    public void addAtIndex(int index, int val) {
        if (length < index) {
            return;
        } else if (length == index) {
            addAtTail(val);
        } else {
            ListNode cur = pre;
            ListNode node = new ListNode(val);
            int count = -1;
            while (count + 1 < index) {
                cur = cur.next;
                count += 1;
            }
            ListNode temp = cur.next;
            cur.next = node;
            node.next = temp;
            length += 1;
        }

    }

    public void deleteAtIndex(int index) {
        if (index < length) {
            ListNode cur = pre;
            int count = -1;
            while (count + 1 < index) {
                cur = cur.next;
                count += 1;
            }

            cur.next = cur.next.next;
            length -= 1;
        }
     }
}

class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(86);
        list.addAtIndex(1,54);
        list.addAtIndex(1,14);
        list.addAtHead(83);
        list.deleteAtIndex(4);
        list.addAtIndex(3,18);
        list.addAtHead(46);
        list.addAtTail(3);
        list.addAtHead(76);
        list.get(5);
    }
}
