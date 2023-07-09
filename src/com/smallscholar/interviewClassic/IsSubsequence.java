package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 17:35
 * @describe 面试经典第二十七题: 392. 判断子序列
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int index = 0;
        int n = s.length();
        int m = t.length();

        for (int i = 0; i < m; i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index += 1;
            }

            if (index == n) {
                break;
            }
        }

        return n == index;
    }

}
