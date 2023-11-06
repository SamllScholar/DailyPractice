package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/27 16:34
 * @version 1.0
 * @describe LCR 006. 两数之和 II - 输入有序数组
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                res[0] = left;
                res[1] = right;
                return res;
            } else if (numbers[left] + numbers[right] < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return res;
    }

}
