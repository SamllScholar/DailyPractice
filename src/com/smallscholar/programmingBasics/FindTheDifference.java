package com.smallscholar.programmingBasics;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 9:28
 * @describe 编程入门第二题: 389. 找不同
 */
public class FindTheDifference {

    /**
     * 最垃圾的计数
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Character key : tMap.keySet()) {
            if (!sMap.containsKey(key) || !Objects.equals(sMap.get(key), tMap.get(key))) {
                return key;
            }
        }

        return 'a';
    }

    /**
     * 使用求和的方法,分别对两个字符串的所有字符串求他们的ascii码的和,最后相减就可以了
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference01(String s, String t) {
        int sSum = 0;
        int tSum = 0;
        for (int i = 0; i < s.length(); i++) {
            sSum += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tSum += t.charAt(i);
        }
        return (char) (tSum - sSum);
    }

    /**
     * 使用位运算的方式进行求和
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference02(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
            res ^= t.charAt(i);
        }
        return (char) (res ^ t.charAt(s.length()));
    }




}
