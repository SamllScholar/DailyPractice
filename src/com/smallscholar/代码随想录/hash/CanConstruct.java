package com.smallscholar.代码随想录.hash;

import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 20:43
 * @describe 383. 赎金信
 */
public class CanConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        char[] magazines = magazine.toCharArray();
        char[] ransomNotes = ransomNote.toCharArray();
        for (char c : magazines) {
            chars[c - 'a'] += 1;
        }

        for (char c : ransomNotes) {
            if (--chars[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }

}
