package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 14:12
 * @describe ...
 */
public class ReverseString {

    public String solve (String str) {
        if (str == null) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

}
