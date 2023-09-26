package com.smallscholar.newStart.september;

import com.smallscholar.programmingIntroduction.CountGoodTriplets;

/**
 * @author smallscholar
 * @date 2023/9/26 13:02
 * @version 1.0
 * @describe 2240. 买钢笔和铅笔的方案数
 */
public class Day_01 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        if (cost1 < cost2) {
            return waysToBuyPensPencils(total, cost2, cost1);
        }

        long count = 0;
        int num = 0;

        while (num * cost1 <= total) {
            // 这里加一的原因是买0个也算一种方案
            count += (total - num * cost1) / cost2 + 1;
            num += 1;
        }

        return count;
    }

}
