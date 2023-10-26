package com.smallscholar.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author smallscholar
 * @date 2023/10/26 23:05
 * @version 1.0
 * @describe 2475. 数组中不等三元组的数目
 */
public class UnequalTriplets {

    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.merge(x, 1, Integer::sum);
        }
        int res = 0, n = nums.length, t = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            res += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 4, 3};
        int i = new UnequalTriplets().unequalTriplets(nums);

        System.out.println(i);
    }

}
