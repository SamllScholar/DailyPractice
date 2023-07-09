package com.smallscholar.代码随想录.hash;

import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 16:33
 * @describe 202. 快乐数
 */
public class IsHappy {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            n /= 10;
            sum += num * num;
        }

        return sum;
    }

}
