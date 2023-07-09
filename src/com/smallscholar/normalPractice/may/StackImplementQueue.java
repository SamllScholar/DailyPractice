package com.smallscholar.normalPractice.may;

import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 20:40
 * @describe 用两个栈实现队列: 判断栈是否为空用stack.size();
 */
public class StackImplementQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2 .size() == 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackImplementQueue stackImplementQueue = new StackImplementQueue();
        stackImplementQueue.push(1);
        stackImplementQueue.push(2);
        int num = stackImplementQueue.pop();
        int num2 = stackImplementQueue.pop();

    }

}
