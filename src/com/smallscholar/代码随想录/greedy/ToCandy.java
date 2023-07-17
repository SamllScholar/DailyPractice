package com.smallscholar.代码随想录.greedy;

import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 9:00
 * @describe 135. 分发糖果
 */
public class ToCandy {

    public int candy(int[] arr) {
        int n = arr.length;
        int res = 1;
        int inc = 1;
        int des = 0;
        int pre = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                des = 0;
                pre = arr[i] == arr[i - 1] ? 1 : pre + 1;
                res += pre;
                inc = pre;
            } else {
                des += 1;
                if (des == inc) {
                    des += 1;
                }
                res += des;
                pre = 1;
            }
        }

        return  res;
    }

}
