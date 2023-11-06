package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/27 16:02
 * @version 1.0
 * @describe LCR 004. 只出现一次的数字 II
 * 这道题最简单的方式就是使用哈桑表,但是这种方法的空间复杂度是o(n)不符合题目的要求, 所以可以使用一个32位的数组来保存
 * 每个数位出现的1的个数
 * 这个题还可以使用数字电路的知识来解答, 具体的代码可以看官方的题解
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        int res = 0;

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    counts[i] += 1;
                }
            }
        }

        for (int i = 0; i < 32; i++) {
            if (counts[i] % 3 == 1) {
                res += 1 >> i;
            }
        }

        return res;
    }

}
