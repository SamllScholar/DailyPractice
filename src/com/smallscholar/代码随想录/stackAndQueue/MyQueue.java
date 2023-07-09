package com.smallscholar.代码随想录.stackAndQueue;

import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:13
 * @describe 232. 用栈实现队列
 */
class MyQueue {

    Stack<Integer> stack01;
    Stack<Integer> stack02;

    public MyQueue() {
        stack01 = new Stack<>();
        stack02 = new Stack<>();
    }

    public void push(int x) {
        stack01.push(x);
    }

    public int pop() {
        if (stack02.size() == 0) {
            while (stack01.size() > 0) {
                stack02.push(stack01.pop());
            }
        }

        return stack02.pop();
    }

    public int peek() {
        if (stack02.size() == 0) {
            while (stack01.size() > 0) {
                stack02.push(stack01.pop());
            }
        }
        return stack02.peek();
    }

    public boolean empty() {
        return stack01.empty() && stack02.empty();
    }
}
