package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 17:27
 * @describe 编程基础第二十六题: 125. 验证回文串
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z'){
                sb.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) (ch + 32));
            } else if (ch >= '0' && ch <= '9'){
                sb.append(ch);
            }
        }

        return sb.toString().contentEquals(sb.reverse());
    }

}
