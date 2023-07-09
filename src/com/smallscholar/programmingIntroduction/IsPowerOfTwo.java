package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 23:04
 * @describe 编程入门第十三题: 231. 2 的幂
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }

}
