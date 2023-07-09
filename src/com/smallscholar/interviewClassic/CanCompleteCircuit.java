package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 9:15
 * @describe 面试经典第十四题; 134. 加油站
 */
public class CanCompleteCircuit {

    public int canCompleteCircuitUp(int[] gas, int[] cost) {
        // 如果cur<0证明当前的起点无解,更新起点
        int cur = 0;
        // 用来判断是否有解
        int total = 0;
        // 用来寻找解的位置
        int index = -1;

        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                index = i;
            }
        }

        if (total < 0) {
            return -1;
        } else {
            return (index + 1) % gas.length;
        }
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // 表示当前开始的位置, 默认从0号加油站开始
        int i = 0;

        // 从头到尾遍历每个加油站，并且检查以该加油站为起点，能否行驶一周
        while(i < n){
            int sumOfGas  = 0; // 总共加的油
            int SumOfCost = 0; // 总共消费的油
            int count = 0;     // 记录能走过几个站点
            while(count < n){  // 退出循环的条件是走过所有的站点
                int j = (i + count) % n; // 加油站是环形的
                sumOfGas += gas[j];
                SumOfCost += cost[j];
                if(SumOfCost > sumOfGas){ // 如果这个站点发现油不够了
                    break;
                }
                count++; // 这个站点满足情况
            }

            if(count == n){  // 如果能环绕一圈
                return i;
            }else{
                // 不行的话 从下一个站点开始 检查
                // 从i开始都到不了i + count的话, 那么从i + count 更加到不了i + count + 1了
                // 直接从i + count开始的话,那么初始和油量就是0, 从i开始到i + count 的时候初始的油量一定 >= 0所以从i
                // 开始的话到不了, 那么从i+count开始一定也到不了所以可以直接从i + count + 1开始
                i = i + count + 1;
            }
        }
        // 所有加油站作为起点都不满足
        return -1;
    }

}
