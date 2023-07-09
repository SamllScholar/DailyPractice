package com.smallscholar.代码随想录.string;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 21:36
 * @describe 344. 反转字符串
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right++];
            s[right--] = temp;
        }
    }

}
