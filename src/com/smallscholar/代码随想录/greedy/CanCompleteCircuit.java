package com.smallscholar.代码随想录.greedy;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 8:50
 * @describe 134. 加油站
 */
public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        // 求解的起点
        int index = 0;
        // total是用来判断是否有可用解
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (cur < 0) {
                cur = 0;
                index = i;
            }
        }

        return total < 0 ? -1 : (index + 1) % gas.length;
    }

}
