package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 23:22
 * @describe 第十五题: 263. 丑数
 */
public class IsUgly {

    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        // 如果n为丑数,那么n = 2^x + 3^y + 5^z; x,y,z >= 0当都为0的时候n = 1也是丑数所以可以反复的除以2, 3, 5
        // 如果最后的结果为1那么就是丑数, 如果最后的结果不为1, 那么就不是丑数
        int[] nums = {2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }

        return n == 1;
    }

}
