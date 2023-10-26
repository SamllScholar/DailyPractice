package com.smallscholar.random;

import java.util.Arrays;

/**
 * @author smallscholar
 * @date 2023/10/22 21:51
 * @version 1.0
 * @describe lc: 910. 最小差值 II
 */
public class SmallestRangeII {

    public int smallestRangeII(int[] nums, int k) {
        // 对数组进行排序，方便找到数组原来最大的元素与最小的元素
        Arrays.sort(nums);
        int n = nums.length;
        // 拿到数组中的最大的值与最小的值
        int maxVal = nums[n  -1];
        int minVal = nums[0];
        int res = nums[n - 1] - nums[0];

        for (int i = 0; i < n - 1; i++) {
            // 遍历每一个元素, 分别在遍历每一个元素的时候找到当前的最大值与最大值然后求出来差值,然后找这些最大值的最小值
            int x = nums[i];
            int y = nums[i + 1];

            int high = Math.max(maxVal - k, x + k);
            int low = Math.min(minVal + k, y - k);

            res = Math.min(res, high - low);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6};
        int k = 3;

        int res = new SmallestRangeII().smallestRangeII(nums, k);

        System.out.println(res);
    }

}
