package com.smallscholar.代码随想录.hash;

import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 17:04
 * @describe #第454题.四数相加II
 */
public class FourSumCount {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = 0;

        for (int num01 : nums1) {
            for (int num02 : nums2) {
                hashMap.put(num01 + num02, hashMap.getOrDefault(num01 + num02, 0) + 1);
            }
        }

        for (int num03 : nums3) {
            for (int num04 : nums4) {
                if (hashMap.containsKey(-num03 - num04)) {
                    res += hashMap.get(-num03 - num04);
                }
            }
        }

        return res;
    }

}
