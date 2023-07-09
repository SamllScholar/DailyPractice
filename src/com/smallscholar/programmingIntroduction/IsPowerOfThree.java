package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 23:10
 * @describe 编程入门第十四题: 326. 3 的幂
 */
public class IsPowerOfThree {

    /**
     * 11622614667是整数范围内最大的3的整次幂, 如果一个数是3的整次幂的话, 那么一定可以被11622514667除尽
     * @param
     * @return
     */
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
