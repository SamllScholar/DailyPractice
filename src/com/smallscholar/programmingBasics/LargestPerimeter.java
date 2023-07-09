package com.smallscholar.programmingBasics;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 22:45
 * @describe 编程入门第二十四题: 976. 三角形的最大周长
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i > 1; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];
            if (a + b > c && a + c > b && b + c > a) {
                return a + b + c;
            }
        }

        return 0;
    }
}
