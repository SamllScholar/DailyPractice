package com.smallscholar.normalPractice.may;

import java.awt.datatransfer.StringSelection;
import java.util.HashMap;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 13:55
 * @describe ...
 */
public class MinWindow {

    public String minWindow(String S, String T) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ht = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            ht.put(T.charAt(i), ht.getOrDefault(T.charAt(i), 0) + 1);
        }
        String res = "";
        int len = Integer.MAX_VALUE;
        int count = 0;

        for (int left = 0, right = 0; right < S.length(); right++) {
            hs.put(S.charAt(right), hs.getOrDefault(S.charAt(right), 0) + 1);
            if (ht.containsKey(S.charAt(right)) && ht.get(S.charAt(right)) >= hs.get(S.charAt(right))) {
                count += 1;
            }
            while (left < right && (!ht.containsKey(S.charAt(left)) || ht.get(S.charAt(left)) < hs.get(S.charAt(left)))) {
                hs.put(S.charAt(left), hs.get(S.charAt(left)) - 1);
                left += 1;
            }
            if (count == T.length() && len > right - left + 1) {
                len = right - left + 1;
                res = S.substring(left, right + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "XDOYEZODEYXNZ";
        String t = "XYZ";
        String res = new MinWindow().minWindow(s, t);
        System.out.println(res);
    }

}
