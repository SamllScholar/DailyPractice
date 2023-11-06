package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/27 15:38
 * @version 1.0
 * @describe LCR 003. 比特位计数
 * 这是一个规律题, 找到了规律,然后使用简单的dp就可以解决这个问题
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;

        for (int i = 1; i <= n; i++) {
            res[i] = i % 2 == 0 ? res[i / 2] : res[i / 2] + 1;
        }

        return res;
    }

}
