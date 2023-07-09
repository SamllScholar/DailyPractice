package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 14:30
 * @describe 面试经典第十八题: 135. 分发糖果
 */
public class Candy {

    public int candy(int[] arr) {
        int n = arr.length;
        // 第一个同学一定分得一个糖果, 所以不用遍历直接分配就行
        int res = 1;
        // dec当前递减序列的长度,inc最近的递增序列的长度,pre前一个同学分的数量
        int inc = 1, dec = 0, pre = 1;
        // 从第二个同学开始分配
        for (int i = 1; i < n; i++) {
            // 如果当前的序列是递增的, 那么递减序列的长度就为0
            if (arr[i] >= arr[i - 1]) {
                dec = 0;
                pre = arr[i] == arr[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                // 如果当前的序列是递减序列
                dec++;
                // 如果递减的和递增的相等的话, 那么递减的还得再加一,因为如果不加一就出现大小不一样但是相等的了
                if (dec == inc) {
                    dec++;
                }
                // 结果加上当前的递减序列的长度
                res += dec;
                pre = 1;
            }
        }
        return res;
    }

}
