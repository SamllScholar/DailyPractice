package com.smallscholar.代码随想录.dynamic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 14:34
 * @describe 509. 斐波那契数
 */
public class Fib {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }

}
