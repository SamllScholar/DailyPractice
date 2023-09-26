package com.smallscholar.newStart.september;

import java.util.HashSet;

/**
 * @author smallscholar
 * @date 2023/9/26 13:51
 * @version 1.0
 * @describe 2605. 从两个数字数组里生成最小数字
 */
public class Day_05 {

    public int minNumber(int[] nums1, int[] nums2) {
        int res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int j : nums1) {
            min = Math.min(j, min);
            set.add(j);
        }

        for (int j : nums2) {
            if (set.contains(j)) {
                res = Math.min(res, j);
            }
            res = Math.min(res, Math.min(min * 10 + j, j * 10 + min));
        }

        return res;
    }

}
