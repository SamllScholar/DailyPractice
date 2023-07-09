package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 21:34
 * @describe 变成入门第三题: 2413. 最小偶倍数
 */
public class SmallestEvenMultiple {

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else {
            return 2 * n;
        }
    }

}
