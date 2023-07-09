package com.smallscholar.interviewClassic;

import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 9:45
 * @describe 面试经典第十五题: 剑指 Offer 03. 数组中重复的数字
 */
public class FindRepeatNumber {

    public int findRepeatNumberUp(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // 如果当前位置的元素和当前到的索引相同, 那么证明当前元素的位置是对, 开始下一次遍历
            if (nums[i] == i) {
                i++;
                continue;
            }
            // 如果当前元素的位置不对, 但是和元素位置对的相等了, 那么证明当前的元素重复了, 直接进行返回
            if (nums[nums[i]] == nums[i]) return nums[i];
            // 如果当前元素没有重复, 那么就可以把当前的元素交换到合适的位置了
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return nums[i];
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        return -1;
    }

}
