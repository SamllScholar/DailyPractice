package com.smallscholar.normalPractice.may;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 15:54
 * @describe 接雨水问题
 * 方法:
 * 暴力: 依次以每一个都作为一个端点
 * 单调栈:
 */
public class MaxWater {

    // 单调栈,单调递减的栈, 栈里面存的是当前值对应的索引
    public long maxWater(int[] arr) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            // 如果当前的元素不为空,并且栈顶的元素小于当前的元素
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // 把栈顶的元素弹出, 如果弹出之后当前的栈为空证明当前已经不可以解接雨水,退出当前的循环
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(arr[left], arr[i]) - arr[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    // 双指针
    public long maxWater2(int[] arr) {
        int ans = 0;
        int left = 0, right = arr.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (arr[left] < arr[right]) {
                ans += leftMax - arr[left];
                ++left;
            } else {
                ans += rightMax - arr[right];
                --right;
            }
        }
        return ans;
    }

}
