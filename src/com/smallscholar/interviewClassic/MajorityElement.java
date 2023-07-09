package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 18:30
 * @describe 面试经典第五题: 169. 多数元素
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }

}
