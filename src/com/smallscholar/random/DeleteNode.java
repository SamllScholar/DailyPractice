package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/22 23:19
 * @version 1.0
 * @describe 237. 删除链表中的节点
 * 这里的删除不是字面意思上的删除,仅仅是把当前节点的值去掉, 可以当前节点的每一个后面节点的值前移一个就可以了
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            ListNode temp = node.next;
            node.val = temp.val;
            node = temp;
        }
        node.val = node.next.val;
        node.next = null;
    }

}
