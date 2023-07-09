package com.smallscholar.dailyPractice.may;

import javax.swing.*;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 9:05
 * @describe ...
 */
public class IsCircularSentence {

    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        int n = s.length;
        for (int i = 0; i < n - 1; i++) {
            char pre = s[i].charAt(s[i].length() - 1);
            char post = s[i + 1] .charAt(0);
            if (pre != post) {
                return false;
            }
        }

        return s[0].charAt(0) == s[s.length - 1].charAt(s[s.length - 1].length() - 1);
    }

}
