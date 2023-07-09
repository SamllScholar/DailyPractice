package com.smallscholar.interviewClassic;

import com.smallscholar.programmingBasics.LargestPerimeter;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/2 16:44
 * @describe 面试经典第十题: 45. 跳跃游戏 II
 */
public class Jump {

    /**
     * 多向前看一步
     * 1. 获得当前这一步可以走的最远的距离
     * 2. 在这个距离内找到,下一步可以走的最远的距离的位置
     * 3. 当前的这一步就更新到这个位置
     * 4. 重置当前这一走到的最远的距离就是2中求出来的距离
     * 5. 然后继续求下一步的最远的距离
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int step = 0;
        // 当前这一步可以走到的最远的距离 --> 走一步可以走的最远的距离
        int first = 0;
        // 在这个最远的距离内再走出去一步的最远的距离 --> 走两步可以走的最远的距离
        int next = first;

        for (int i = 0; i < nums.length - 1; i++) {
            // 在第一步的最远距离内, 找出第二步的最远距离
            if (i + nums[i] > next) {
                next = i + nums[i];
            }
            // 如果当前遍历到第一步的最远距离了,那么当前的这一步就可以跨除了, 因为下一步的最远距离已经找到了
            if (i == first) {
                // 走出去这一步, 然后把走两步的最远距离更新到走一步的最远距离中, 循环重新获取走两步的最远距离
                first = next;
                step += 1;
            }
        }

        return step;
    }

}
