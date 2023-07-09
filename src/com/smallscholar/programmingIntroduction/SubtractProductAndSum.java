package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 23:00
 * @describe 变成入门第十二题: 1281. 整数的各位积和之差
 */
public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;

        while (n != 0) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }

        return mul - sum;
    }

}
