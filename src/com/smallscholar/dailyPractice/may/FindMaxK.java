package com.smallscholar.dailyPractice.may;

import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/13 20:55
 * 2441. 与对应负数同时存在的最大正整数
 */
public class FindMaxK {

    public int findMaxK(int[] nums) {
        int res = -1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(-num)) {
                res = Math.max(res, Math.abs(num));
            }
            hashSet.add(num);
        }
        return res;
    }

}
