package com.smallscholar.代码随想录.backTracking;

import sun.security.krb5.internal.crypto.dk.DkCrypto;

import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/10 9:58
 * @describe ...
 */
public class LetterCombinations {

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        backTracking(digits, 0);
        return ans;
    }

    public void backTracking(String digits, int index) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        if (index >= digits.length()) {
            return;
        }
        char c = digits.charAt(index);
        String s = getString(c);

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backTracking(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getString(char ch) {
        String ans = "";
        switch (ch) {
            case '2':
                ans = "abc";
                break;
            case '3':
                ans = "def";
                break;
            case '4':
                ans = "ghi";
                break;
            case '5':
                ans = "jkl";
                break;
            case '6':
                ans = "mno";
                break;
            case '7':
                ans = "pqrs";
                break;
            case '8':
                ans = "tuv";
                break;
            default:
                ans = "wxyz";

        }

        return ans;
    }


}
