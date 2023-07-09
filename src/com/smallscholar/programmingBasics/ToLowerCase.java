package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 14:05
 * @describe 编程基础第十二题: 709. 转换成小写字母
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append((char) (s.charAt(i) + 32));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
