package com.smallscholar.代码随想录.dynamic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 16:24
 * @describe 343. 整数拆分
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

}
