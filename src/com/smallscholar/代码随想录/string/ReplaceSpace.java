package com.smallscholar.代码随想录.string;

import sun.security.krb5.Asn1Exception;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 22:00
 * @describe 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                ans.append("%20");
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

}
