package com.smallscholar.bi.mt.day_8_19;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/23 17:23
 * @describe 3、小美的 01 串翻转
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230819/#%E5%B0%8F%E7%BE%8E%E7%9A%8401%E4%B8%B2%E7%BF%BB%E8%BD%AC
 */
public class Demo03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        int n = chars.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int count01 = 0;
            int count02 = 0;
            for (int j = i; j < n; j++) {
                if ((j % 2 == 0 && (chars[j] & 1) == 1) || (j % 2 == 1 && (chars[j] & 1) == 0)) {
                    count01++;
                }
                if ((j % 2 == 0 && (chars[j] & 1) == 0) || (j % 2 == 1 && (chars[j] & 1) == 1)) {
                    count02++;
                }
                res += Math.min(count01, count02);
            }
        }

        System.out.println(res);
    }

}
