package com.smallscholar.代码随想录.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:19
 * @describe 225. 用队列实现栈
 * 我这种方法时复杂了
 * 官方解法:
 * 思路一: 如果是添加直接添加到queue02中, 然后把queue01中的元素添加到queue02后面, 这样后进的就在队首了, 然后把queue01和queue02交换
 * 思路二: 使用一个队列, 先计算出当前队列的长度, 然后添加一个元素, 使用一个for循环 queue.add(queue.poll())即可
 */
class MyStack {

    Queue<Integer> queue01;
    Queue<Integer> queue02;

    public MyStack() {
        queue01 = new ArrayDeque<>();
        queue02 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue01.add(x);
    }

    public int pop() {
        while (queue01.size() > 0) {
            queue02.add(queue01.poll());
        }
        int ans = queue01.poll();
        while (queue02.size() > 0) {
            queue01.add(queue02.poll());
        }

        return ans;
    }

    public int top() {
        int ans = -1;
        while (queue01.size() > 0) {
            if (queue01.size() == 1) {
                ans = queue01.peek();
            }
            queue02.add(queue01.poll());

        }
        while (queue02.size() > 0) {
            queue01.add(queue02.poll());
        }

        return ans;
    }

    public boolean empty() {
        return queue01.isEmpty();
    }
}

class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        int top = myStack.top();
        System.out.println(top);
    }
}