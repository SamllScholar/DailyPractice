package com.smallscholar.dailyPractice.may;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/4 8:57
 * @describe 23.07.04的每日一题: 2679. 矩阵中的和
 */
public class MatrixSum {

    /**
     * 先对每一行分别进行排序, 然后分别计算每一列中的最大的值加到结果中就可以了
     * @param nums
     * @return
     */
    public int matrixSum(int[][] nums) {
        int res = 0;
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums[i]);
        }
        for (int j = 0; j < n; j++) {
            int maxVal = 0;
            for (int i = 0; i < m; i++) {
                maxVal = Math.max(maxVal, nums[i][j]);
            }
            res += maxVal;
        }
        return res;
    }

}
