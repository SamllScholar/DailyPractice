package com.smallscholar.代码随想录.string;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 23:41
 * @describe 459. 重复的子字符串
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

}
