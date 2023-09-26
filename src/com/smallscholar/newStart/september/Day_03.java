package com.smallscholar.newStart.september;

import java.util.Arrays;

/**
 * @author smallscholar
 * @date 2023/9/26 13:36
 * @version 1.0
 * @describe 1921. 消灭怪物的最大数量
 * 贪心, 根据怪物到达的时间进行排序, 然后挨个消灭
 */
public class Day_03 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return n;
    }

}
