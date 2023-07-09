package com.smallscholar.代码随想录.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 1:06
 * @describe 239. 滑动窗口最大值
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 一定是n - k + 1;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            // 如果相等, 刚好过期
            if (i - k == deque.peekFirst()) {
                deque.removeFirst();
            }
            // 当前遍历的元素已经可以形成一个窗口后, 返回该窗口内的最大值
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }

}
