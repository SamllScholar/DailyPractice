package com.smallscholar.programmingBasics;

import java.security.interfaces.RSAKey;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 15:43
 * @describe 编程基础第十九题: 1572. 矩阵对角线元素的和
 */
public class DiagonalSum {

    public int diagonalSum(int[][] mat) {
        int res = 0;

        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    res += mat[i][j];
                    int k = n - 1 - j;
                    if (k != j) {
                        res += mat[i][k];
                    }
                }
            }
        }

        return res;
    }

}
