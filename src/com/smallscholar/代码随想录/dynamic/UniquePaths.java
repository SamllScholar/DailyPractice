package com.smallscholar.代码随想录.dynamic;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 15:40
 * @describe 62. 不同路径
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
