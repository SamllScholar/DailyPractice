package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/25 21:02
 * @version 1.0
 * @describe ...
 */
public class CountSeniors {

    public int countSeniors(String[] details) {
        int res = 0;
        int n = details.length;

        for (int i = 0; i < n; i++) {
            String s = details[i];
            int age = Integer.parseInt(s.substring(s.length() - 4, s.length() - 2));
            res = age > 60 ? res + 1 : res;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        int i = new CountSeniors().countSeniors(details);
        System.out.println(i);
    }

}
