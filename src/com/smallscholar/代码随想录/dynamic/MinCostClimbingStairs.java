package com.smallscholar.代码随想录.dynamic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 14:55
 * @describe 746. 使用最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            if (i == cost.length){
                dp[i] = dp[i - 1] + dp[i - 2];
                continue;
            }
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return dp[cost.length];
    }

}
