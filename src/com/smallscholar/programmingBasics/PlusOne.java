package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 11:03
 * @describe 编程基础第七题: 66. 加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            // 找到数组中第一个不是9的数字, 然后加一, 后面的是9的遍布变成0就可以了
            if (digits[i] != 9) {
                ++digits[i];
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        // 对于全是9的情况但是进行考虑
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

}
