package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/2 16:15
 * @describe 面试经典第八题: 122. 买卖股票的最佳时机 II
 * 和股票一一样, 如果当前的股票比之前的大, 那么就可以卖
 */
public class MaxProfitTwo {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = new MaxProfitTwo().maxProfit(prices);
        System.out.println(i);
    }

}
