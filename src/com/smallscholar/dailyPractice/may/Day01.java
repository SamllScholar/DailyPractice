package com.smallscholar.dailyPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/26 8:42
 * @describe leetcode: 2485. 找出中枢整数
 * 思路: 使用等差数列求和的思想,分别以x为分界线的等差数列求和, 然后进行公式的化简就可以得到下面的表达式了
 */
public class Day01 {

    public int pivotInteger(int n) {
        int temp = (n * n + n) / 2;
        int x = (int)Math.sqrt(temp);
        return x * x == temp ? x : -1;
    }

}
