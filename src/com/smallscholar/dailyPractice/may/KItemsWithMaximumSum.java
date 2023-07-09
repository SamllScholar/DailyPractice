package com.smallscholar.dailyPractice.may;

import javax.naming.spi.ResolveResult;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/5 9:25
 * @describe 2600. K 件物品的最大和
 */
public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        res += Math.min(k, numOnes);
        k = Math.max(0, k - numOnes - numZeros);
        res -= Math.min(k, numNegOnes);

        return res;
    }

}
