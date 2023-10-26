package com.smallscholar.random;

import java.util.Arrays;

/**
 * @author smallscholar
 * @date 2023/10/26 22:31
 * @version 1.0
 * @describe 1509. 三次操作后最大值与最小值的最小差
 * 思路: 最多可以进行三次改变数值的操作, 所以最多改变三次最大值或者改变三次最小值, 或者改变一次最大值两次最小值.....
 */
public class MinDifference {

    public int minDifference(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if (n <= 4) {
           return 0;
        }

        for (int i = 0; i < 4; i++){
            res = Math.min(res, nums[n - 4 + i] - nums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,0,10,14};

        int i = new MinDifference().minDifference(nums);

        System.out.println(i);
    }

}
