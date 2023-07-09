package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 10:52
 * @describe 编程基础第六题: 283. 移动零
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right++;
                continue;
            }
            nums[left++] = nums[right++];
        }

        for (int i = left; i < nums.length; i++) {
            nums[left] = 0;
        }
    }

}
