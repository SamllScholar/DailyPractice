package com.smallscholar.lcr;

import java.util.Stack;

/**
 * @author smallscholar
 * @date 2023/11/5 21:15
 * @version 1.0
 * @describe LCR 028. 扁平化多级双向链表
 * 思路: 使用bfs深度遍历优先的思想, 并且使用一个栈当当前的节点既有子节点又有下一个节点的时候, 要把下一个节点保存起来
 */
public class Flatten {

    Stack<Node> stack;

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        stack = new Stack<>();
        // 当前的节点既有子节点又有next节点, 因为需要访问子节点, 所以要把next节点保存起来, 使用栈的数据结构这样保证了先进先出的顺序
        if (head.next != null && head.child != null) {
            stack.push(head.next);
        }
        // 如果当前的节点有子节点的话需要先访问子节点, 如果没有子节点的话那么就访问next节点
        bfs(head, head.child == null ? head.next : head.child, stack);
        return head;

    }

    public void bfs(Node pre, Node head, Stack<Node> stack) {
        // 如果当前的节点为空表示所有的节点已经遍历完成
        if (head == null) {
            return;
        }
        // 把已经访问完的节点的子节点全部变成空(不要要再次操作了), 然后改变上一个节点和当前节点的指向, 上一个节点执行当前的节点
        pre.child = null;
        pre.next = head;
        head.prev = pre;
        pre = pre.next;

        // 如果当前的节点有子节点, 那么要先访问子节点, 如果当前节点还有next节点需要先保存next节点
        if (head.child != null) {
            if (head.next != null) {
                stack.push(head.next);
            }
            bfs(pre, head.child, stack);
        } else if (head.next != null){
            // 如果当前的节点没有子节点但是有next节点, 那么就直接访问next节点
            bfs(pre, head.next, stack);
        } else if (!stack.isEmpty()) {
            // 如果当前层的所有的节点都已经访问完成,但是上一层还有没访问完成的节点那么就继续访问没有访问完成的节点(stack不为空)
            head = stack.pop();
            bfs(pre, head, stack);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 3;
        Node node4 = new Node();
        node4.val = 4;
        node1.next = node2;
        node2.prev = node1;
        node1.child = node3;
        node3.next = node4;
        node4.prev = node3;

        Node flatten = new Flatten().flatten(node1);
        System.out.println(flatten);
    }


}
