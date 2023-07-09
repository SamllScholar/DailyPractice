package com.smallscholar.代码随想录.hash;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 16:20
 * @describe 242. 有效的字母异位词
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] flag = new int[26];

        for (int i = 0; i < s.length(); i++) {
            flag[s.charAt(i) - 'a'] += 1;
            flag[t.charAt(i) - 'a'] -= 1;
        }

        for (int i : flag) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

}
