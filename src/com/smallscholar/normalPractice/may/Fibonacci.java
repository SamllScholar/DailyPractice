package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/26 14:00
 * @describe ...
 */
public class Fibonacci {

    public int Fibonacci (int n) {
        if (n <= 2) {
            return 1;
        }
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n - 1];
    }

}
