package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/2 15:37
 * @describe 面试经典第七题: 121. 买卖股票的最佳时机
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        // 贪心选择, 我们通过遍历找到到当前位置的最小的price, 如果当前的元素大于minPrice, 可以考虑是否卖出,
        // 如果当前的元素小于minPrice更新minPrice
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }

}
