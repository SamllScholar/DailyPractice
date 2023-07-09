package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 17:43
 * @describe 面试经典第二十八题: 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int right = n - 1;
        int left = 0;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }

        return new int[]{};
    }

}
