package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 15:38
 * @describe 编程基础第十八题: 1672. 最富有客户的资产总量
 */
public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                temp += accounts[i][j];
            }
            max = Math.max(max, temp);
        }

        return max;
    }

}
