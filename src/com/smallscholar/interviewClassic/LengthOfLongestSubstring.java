package com.smallscholar.interviewClassic;

import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/4 14:06
 * @describe 面试经典第三十二题: 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        int n = s.length();
        int res = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
                res = Math.max(hashMap.size(), res);
            } else {
                while (left <= right && s.charAt(left) != ch) {
                    hashMap.remove(s.charAt(left++));
                }
                hashMap.put(ch, 1);
                left += 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aabaab!bb";
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
