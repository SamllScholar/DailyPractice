package com.smallscholar.代码随想录.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 16:59
 * @describe 1. 两数之和
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                return new int[] {i , hashMap.get(num)};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }

}
