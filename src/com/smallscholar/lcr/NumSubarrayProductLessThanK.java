package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/29 22:11
 * @version 1.0
 * @describe LCR 009. 乘积小于 K 的子数组
 */
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int res = 0;

        for (int left = 0; left < n; left++) {
            int temp = 1;
            for (int right = left; right < n; right++) {
                temp *= nums[right];
                if (temp < k) {
                    res += 1;
                } else {
                    break;
                }
            }
        }


        return res;
     }

}
