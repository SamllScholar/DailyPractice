package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 15:06
 * @describe 面试经典第一题: 88. 合并两个有序数组
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int k = x + y + 1;

        while (k >= 0 && (x >= 0 || y >= 0)) {
            int a = x >= 0 ? nums1[x] : Integer.MIN_VALUE;
            int b = y >= 0 ? nums2[y] : Integer.MIN_VALUE;

            nums1[k--] = Math.max(a, b);
            if (a >= b) {
                x--;
            } else {
                y--;
            }
        }
    }

}
