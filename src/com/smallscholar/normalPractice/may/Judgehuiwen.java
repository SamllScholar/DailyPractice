package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/20 15:03
 * @describe 判断是否是回文
 */
public class Judgehuiwen {

    public boolean judge (String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }

}
