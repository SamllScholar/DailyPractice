package com.smallscholar.代码随想录.binary;

import java.security.interfaces.RSAKey;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 14:34
 * @describe 59. 螺旋矩阵 II
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][]{{1}};
        }
        int[][] res = new int[n][n];
        int val = 1;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;

        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res[up][i] = val++;
            }
            for (int i = up + 1; i <= down; i++) {
                res[i][right] = val++;
            }
            if (up < down && left < right) {
                for (int i = right - 1; i > left; i--) {
                    res[down][i] = val++;
                }
                for (int i = down; i > up; i--) {
                    res[i][left] = val++;
                }
            }
            up++;
            left++;
            right--;
            down--;
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] ints = new GenerateMatrix().generateMatrix(n);
        System.out.println(ints);
    }

}
