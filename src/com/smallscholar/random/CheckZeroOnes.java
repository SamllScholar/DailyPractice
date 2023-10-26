package com.smallscholar.random;

/**
 * @author smallscholar
 * @date 2023/10/22 23:31
 * @version 1.0
 * @describe 1869. 哪种连续子字符串更长
 */
public class CheckZeroOnes {

    public boolean checkZeroOnes(String s) {
        int n = s.length();

        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            while (i < n && s.charAt(i) == '1') {
                count += 1;
                i += 1;
            }

            oneCount = Math.max(oneCount, count);
        }

        for (int i = 0; i < n; i++) {
            int count = 0;

            while (i < n && (s.charAt(i) == '0'))  {

                count += 1;
                i += 1;
            }

            zeroCount = Math.max(zeroCount, count);
        }

        return oneCount > zeroCount;
    }

    public static void main(String[] args) {
        String s = "110100010";

        boolean b = new CheckZeroOnes().checkZeroOnes(s);
        System.out.println(b);
    }

}
