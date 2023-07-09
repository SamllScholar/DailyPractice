package com.smallscholar.代码随想录.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 22:10
 * @describe 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverse(chars, 0, s.length() - 1 - n);
        reverse(chars, s.length() - n, s.length() - 1);

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start <= end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }


}
