package com.smallscholar.bi.tencentMusic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 21:40
 * @describe 1.字符串操作
 * https://www.nowcoder.com/exam/test/72119081/detail?pid=43184608&examPageSource=Company&testCallback=https%3A%2F%2Fwww.nowcoder.com%2Fexam%2Fcompany&testclass=%E8%BD%AF%E4%BB%B6%E5%BC%80%E5%8F%91
 */
public class Question01 {

    public int minOperations (String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        int count = 0;
        int other = 26 - map.size();
        for (Character c : map.keySet()) {
            int num = map.get(c);
            while (num > 1) {
                if (num == 2) {
                    num -= 1;
                    count += 1;
                    continue;
                }
                if (other > 0) {
                    num -= 2;
                    other -= 1;
                    count += 1;
                } else {
                    count += 1;
                    num -= 1;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "eueyeuvdeoyuveoyvyvecevveocedcddvouvudvuuuoydeucvecdycdodcdcdvecooeecdycycydecuc";
        int n = new Question01().minOperations(str);
        System.out.println(n);
    }

}
