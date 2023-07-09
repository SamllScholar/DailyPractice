package com.smallscholar.interviewClassic;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/2 17:57
 * @describe 面试经典第十一题: 274. H 指数
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < citations.length; i++) {
            if (n <= citations[i]) {
                return n;
            } else {
                n--;
            }
        }

        return n;
    }

}
