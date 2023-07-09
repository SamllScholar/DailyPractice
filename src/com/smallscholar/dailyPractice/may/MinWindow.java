package com.smallscholar.dailyPractice.may;

import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 11:09
 * @describe leetcode: 79最小覆盖子串
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        // 定义两个map来保存当前窗口中的字符串的内容,以及目标字符串t的具体的字符结构
        HashMap<Character, Integer> ht = new HashMap<>();
        HashMap<Character, Integer> hs = new HashMap<>();
        // 填充ht
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 定义结果变量res,以及中间用于判断的变量len以及count
        String res = "";
        // 最优解的长度
        int len = Integer.MAX_VALUE;
        // 当前有效字符的个数
        int count = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            // 首先先往临时map中添加一个字符并更新对应字符的数量
            hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0) + 1);
            // 如果当前的字符在ht中(当前字符是需要的字符)并且当前的字符的数量没有溢出,那么有效字符的长度就加一
            if (ht.containsKey(s.charAt(right)) && ht.get(s.charAt(right)) >= hs.get(s.charAt(right))) {
                count++;
            }
            // 如果最左边的字符不在结果字符集中或者最左边对应的字符的数量在hs中大于t的,那么证明后面的字符的数量可以满足结果的要求,左指针加加
            while (left < right && (!ht.containsKey(s.charAt(left)) || ht.get(s.charAt(left)) < hs.get(s.charAt(left)))){
                hs.put(s.charAt(left), hs.get(s.charAt(left)) - 1);
                left += 1;
            }
            // 如果有效字符串的个数等于目标字符串的个数并且当前的这个结果比原来的最优结果的长度短,那么就更新结果字符串以及最优长度
            if (count == t.length() && len > right - left + 1) {
                len = right - left + 1;
                res = s.substring(left, right + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = new MinWindow().minWindow(s, t);
        System.out.println(res);
    }

}
