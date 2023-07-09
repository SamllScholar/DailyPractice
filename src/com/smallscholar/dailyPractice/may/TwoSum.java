package com.smallscholar.dailyPractice.may;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 21:15
 * @describe ...
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[]{};
    }

}
