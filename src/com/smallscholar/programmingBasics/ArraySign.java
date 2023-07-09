package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 11:20
 * @describe 编程基础第8题: 1822. 数组元素积的符号
 */
public class ArraySign {

    public int arraySign(int[] nums) {
        int res = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                res += 1;
            }
        }

        return res % 2 == 0 ? 1 : -1;
    }


}
