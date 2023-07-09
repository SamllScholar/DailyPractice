package com.smallscholar.interviewClassic;

import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author smallscholar42. 接雨水
 * @version 1.0
 * @date 2023/7/3 14:33
 * @describe 面试经典第十九题: 42. 接雨水
 */
public class Trap {

    public int trap(int[] height) {
        int sum = 0;
        int cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (cur < height.length) {
            while (stack.size() > 0 && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.size() <= 0) {
                    break;
                }
                int distance = cur - stack.peek() - 1;
                int minH = Math.min(height[cur], height[stack.peek()]);
                sum += distance * (minH - h);
            }
            stack.push(cur);
            cur += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        int trap = new Trap().trap(height);
        System.out.println(trap);
    }

}
