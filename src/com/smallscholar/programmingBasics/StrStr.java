package com.smallscholar.programmingBasics;

import java.util.Calendar;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 9:45
 * @describe 编程基础第三题: 28. 找出字符串中第一个匹配项的下标
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

    // 在S数组中找到子串m的开始位置, 如果没有或不合法返回-1
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() < m.length()) {
            return -1;
        }

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        // 得到前缀数组: 该数组中保存了当前位置记录的该字符串的前面元素和后面元素相同的个数
        // 比如next[i]就表示该字符串前next[i]个元素和i之前的next[i]个元素相同
        int[] next = getNextArray(str2);
        //
        while (i1 < str1.length && i2 < next.length) {
            //如果两个字符串对应位置的元素相同,则str1和str2都加一
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            }
            //str2当前位置为0，等同与i2 == 0, 没有相同的前缀了, 那么i1之前的str1就不包含str2了
            // 所以i1++, 从新的位置重新判断
            else if (next[i2] == -1) {
                i1++;
            }
            //此时str1和str2不匹配，通过nextArray往前跳，得到i2应该在的下一个位置,
            // 如果next[i2]为k, 那么str2的前k个和i2前的k个应该是相同的, 并且i2可以加到现在证明
            // str1的i1前的k个应该也是个str2的前k个相同的,所以通过next[i2]直接跳到k + 1位置, 就			省去了k步的判断
            else {
                i2 = next[i2];
            }
        }
        //i2越界则匹配成功，结果为i1-i2; 否则i1越界了，此时匹配失败，返回-1
        return ((i2 == str2.length) ? (i1 - i2) : -1);
    }

    /**
     * 获取next数组
     */
    public static int[] getNextArray(char[] ms) {
        //人为规定第一个为-1
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        //人为规定第一个为0
        next[1] = 0;
        //next数组的位置
        int i = 2;
        //拿cn字符和i-1的字符比
        int cn = 0;
        while (i < ms.length) {
            // 如果前面的和后面的相同, 长度要增加
            if (ms[i - 1] == ms[cn]) {
                //next[i] = cn + 1;
                //i++;
                //cn++;此时cn值是next[i-1]的值，这个i是更新后的i
                next[i++] = ++cn;
            }
            //当前跳到cn位置的字符，和i-1位置的字符配不上
            //cn得往前跳，即它的k值
            else if (cn > 0) {
                cn = next[cn];
            }
            //cn <= 0，没办法往前跳了
            //此时next[i]为0
            else {
                next[i++] = 0;
            }
        }
        return next;
    }

}
