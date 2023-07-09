package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 21:48
 * @describe 变成入门第6题: 1512. 好数对的数目
 */
public class NumIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    res += 1;
                }
            }
        }

        return res;

    }

}
