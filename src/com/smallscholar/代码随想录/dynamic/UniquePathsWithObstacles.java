package com.smallscholar.代码随想录.dynamic;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 15:57
 * @describe 63. 不同路径 II
 */
public class UniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean tag = false;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1 || tag == true) {
                dp[i][0] = 0;
                tag = true;
            } else {
                dp[0][i] = 1;
            }
        }
        tag = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1 || tag == true) {
                dp[0][i] = 0;
                tag = true;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
