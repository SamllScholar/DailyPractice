package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/27 15:22
 * @version 1.0
 * @describe LCR 002. 二进制求和
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int n = a.length();
        int m = b.length();
        int i = 0;
        int j = 0;
        int carry = 0;

        while (i < n || j < m) {
            int x = i < n ? a.charAt(i) - '0' : 0;
            int y = j < m ? b.charAt(i) - '0' : 0;
            int sum = x + y + carry;
            str.append(sum % 2);
            carry = sum / 2;
            i += 1;
            j += 1;
        }

        if (carry > 0) {
            str.append(carry);
        }

        return str.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        String string = new AddBinary().addBinary(a, b);
        System.out.println(string);
    }

}
