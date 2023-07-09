package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 17:24
 * @describe 面试经典第二十五题: 28. 找出字符串中第一个匹配项的下标
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 || needle.length() == 0 || haystack.length() < needle.length()) {
            return -1;
        }
        char[] s = haystack.toCharArray();
        char[] m = needle.toCharArray();

        int i = 0;
        int j = 0;

        int[] next = getNextArr(m);

        while (i < s.length && j < m.length) {
            if (s[i] == m[j]) {
                i++;
                j++;
            } else if (next[j] == - 1) {
                i++;
            } else {
                j = next[j];
            }
        }

        return (j == m.length) ? (i - j) : -1;
    }

    public int[] getNextArr(char[] m) {
        if (m.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[m.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i< m.length) {
            if (m[i - 1] == m[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }

        return next;
    }

}
