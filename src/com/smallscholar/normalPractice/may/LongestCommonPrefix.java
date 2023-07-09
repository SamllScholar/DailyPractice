package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/20 13:40
 * @describe 最长公共前缀
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int n = strs.length;
        int len = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();

        for (String str : strs) {
            len = Math.min(len, str.length());
        }

        for (int i = 0; i < len; i++) {
            int count = 0;
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) == ch) {
                    count += 1;
                }
            }
            if (count == n) {
                res.append(ch);
            } else {
                return res.toString();
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"abca", "abc", "abca", "abc", "abcc"};
        String s = new LongestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(s);
    }

}
