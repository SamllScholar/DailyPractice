package com.smallscholar.dailyPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/11 18:24
 * @describe 1911. 最大子序列交替和
 */
public class MaxAlternatingSum {

    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }

}
