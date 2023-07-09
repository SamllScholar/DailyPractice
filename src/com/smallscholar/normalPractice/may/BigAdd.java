package com.smallscholar.normalPractice.may;

import java.math.BigInteger;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/20 14:11
 * @describe 大数加法
 */
public class BigAdd {

    public String solve (String s, String t) {
        // 可以使用java内置的对大数操作的api, 虽然操作简便,但是非常的耗时, 相比于下面的代码慢了10倍
        /*BigInteger a = new BigInteger(s);
        BigInteger b = new BigInteger(t);
        BigInteger c = a.add(b);
        return c.toString();*/

        if (s.length() == 0) {
            return t;
        } else if (t.length() == 0) {
            return s;
        }

        StringBuilder res = new StringBuilder();
        s = res.append(s).reverse().toString();
        res = new StringBuilder();
        t = res.append(t).reverse().toString();
        res = new StringBuilder();
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int carry = 0;
        int length = Math.max(arrS.length, arrT.length);

        for (int i = 0; i < length; i++) {
            int num1 = arrS.length > i ? arrS[i] - '0' : 0;
            int num2 = arrT.length > i ? arrT[i] - '0' : 0;
            int sum = num1 + num2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }

        if (carry == 1) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "1";
        String t = "99";

        String solve = new BigAdd().solve(s, t);
        System.out.println(solve);
    }

}
