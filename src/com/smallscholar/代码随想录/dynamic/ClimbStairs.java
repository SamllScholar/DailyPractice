package com.smallscholar.代码随想录.dynamic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 14:39
 * @describe 70. 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }


}
