package com.smallscholar.normalPractice.may;

import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 20:48
 * @describe 包含min函数的栈
 * 难点: 如何使用O(1)的时间负责找到min
 * 思路: 我们可以在构造的时候构造号min, 而不是在拿的时候再获取
 * 1. 在添加的时候如果min的栈为空,那么我们要添加的就是最小的元素,直接添加就可以了
 * 2. 在添加的时候如果min的栈不为空, 我们就判断一下要添加的元素node和栈顶元素min那么更小如果要添加的元素node更小那么
 * 我们就把node添加到min栈中, 如果min更小那我们就再添加一个相同的min元素就可以了, 这样栈中最小的还是min
 */
public class StackIncludeMin {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.size() == 0) {
            min.push(node);
        } else {
            int peek = min.peek();
            min.push(Math.min(node, peek));
        }
    }

    public void pop() {
        min.pop();
        stack.pop();
    }

    public int top() {
        if (stack.size() == 0) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }

}
