package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 13:07
 * @describe 编程基础第十一题: 罗马数字转整数  --> 逆向思维, 正难则反
 */
public class RomanToInt {

    public int getInt(char romanDigit) {
        switch (romanDigit) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int n = s.length();
        int sum = 0;
        char[] chars = s.toCharArray();
        sum += getInt(chars[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int pre = getInt(chars[i]);
            int post = getInt(chars[i + 1]);
            if (pre < post) {
                sum -= pre;
            } else {
                sum += pre;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String s = "MDCXCV";
        int i = new RomanToInt().romanToInt(s);
        System.out.println(i);
    }

}
