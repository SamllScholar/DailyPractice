package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 9:17
 * @describe 编程基础第一题: 1768. 交替合并字符串
 */
public class MergeAlternately {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());

        for (int i = 0; i < n; i++) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
        }
        res.append(n == word1.length() ? word2.substring(n) : word1.substring(n));
        return res.toString();
    }

}
