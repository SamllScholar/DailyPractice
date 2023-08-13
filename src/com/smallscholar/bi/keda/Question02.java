package com.smallscholar.bi.keda;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 20:00
 * @describe 2、小红走字符串
 * https://ujimatsu-chiya.github.io/EXAM/Kedaxunfei-20230813/#%E5%B0%8F%E7%BA%A2%E8%B5%B0%E5%AD%97%E7%AC%A6%E4%B8%B2
 */
public class Question02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int power = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();
        int i = 1;
        while (power >= 0 && i < n) {
            int num = chars[i] - chars[i - 1];
            power -= num;
            i += 1;
        }

        System.out.println(power);

    }

}
