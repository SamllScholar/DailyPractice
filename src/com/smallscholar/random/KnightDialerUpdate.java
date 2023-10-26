package com.smallscholar.random;

import java.util.Arrays;

/**
 * @author smallscholar
 * @date 2023/10/25 22:24
 * @version 1.0
 * @describe lc:骑士走棋: 状态机的dp
 */
public class KnightDialerUpdate {

    public int knightDialer(int n) {
        int[][] nums = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int mod = 1_000_000_007;
        long[][] dp = new long[n][10];
        // 第一步在任何的位置都是1
        Arrays.fill(dp[0], 1);
        // 从第二步开始
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k : nums[j]) {
                    // 我想在第i步走到j这里,在i - 1步必须在k中
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        long res = 0;

        for (int i = 0; i <= 9; i++) {
            res += dp[n - 1][i];
            res %= mod;
        }

        return (int) res;
    }

}
