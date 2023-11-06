package com.smallscholar.lcr;

import java.util.HashMap;

/**
 * @author smallscholar
 * @date 2023/10/29 22:18
 * @version 1.0
 * @describe LCR 010. 和为 K 的子数组
 */
public class SubarraySum {


    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> tempSum = new HashMap<>();
        // 处理sum和k相等的情况
        tempSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += tempSum.getOrDefault(sum - k, 0);
            tempSum.put(sum, tempSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] nums = {1};

        int i = new SubarraySum().subarraySum(nums, 0);
        System.out.println(i);
    }

}
