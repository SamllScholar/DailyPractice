package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 22:54
 * @describe 编程入门第十一题: 258. 各位相加
 */
public class AddDigits {

    public int addDigits(int num) {
        while (num / 10 != 0) {
            int temp = num;
            int sum = 0;
            while (temp / 10 != 0) {
                sum += temp / 10;
                temp /= 10;
            }
            num = sum + temp;
        }

        return num;
    }

}
