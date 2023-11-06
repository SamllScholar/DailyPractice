package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/27 14:56
 * @version 1.0
 * @describe LCR 001. 两数相除
 */
public class Divide {

    public int divide(int a, int b) {
        // 排除被除数为最小值的情况
        if (a == Integer.MIN_VALUE) {
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 排除除数为最小值的情况
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        // 把除数和被除数都转换为负数, 方便计算
        boolean flag = false;

        if (a > 0) {
            a = -a;
            flag = !flag;
        }
        if (b > 0) {
            b = -b;
            flag = !flag;
        }

        return flag ? -toDivide(a, b) : toDivide(a, b);
    }

    public int toDivide(int a, int b) {
        int res = 0;

        while (a <= b) {
            int value = b;
            int count = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                count += count;
            }

            res += count;
            a -= value;
        }

        return res;
    }

}
