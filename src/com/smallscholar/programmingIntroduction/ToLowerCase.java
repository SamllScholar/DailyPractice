package com.smallscholar.programmingIntroduction;

import java.lang.annotation.ElementType;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 22:48
 * @describe 变成入门第十题: 709. 转换成小写字母 第八题和第九题都是简单的SQL题
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char c = (char) (s.charAt(i) + 32);
                sb.append(c);
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
