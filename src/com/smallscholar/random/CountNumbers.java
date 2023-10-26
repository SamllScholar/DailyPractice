package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/25 21:11
 * @version 1.0
 * @describe lc: LCR 135. 报数
 */
public class CountNumbers {

    public int[] countNumbers(int cnt) {
        int count = 1;

        while (cnt > 0) {
            count =  count * 10;
            cnt -= 1;
        }
        int[] res = new int[count-1];

        for (int i = 1; i < count; i++) {
            res[i - 1] = i;
        }

        return res;
    }

}
