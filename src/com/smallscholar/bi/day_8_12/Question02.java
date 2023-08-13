package com.smallscholar.bi.day_8_12;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 14:39
 * @describe 2、小美走公路
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230812/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E6%8E%92%E5%88%97%E8%AF%A2%E9%97%AE
 */
public class Question02 {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        int[] sum = new int[n + 1];
        int x = sc.nextInt();
        int y = sc.nextInt();
        int num01 = 0;
        int num02 = 0;
        for (int i = 0; i <= n; i++) {
            if (i > 0) {
                nums[i] = sc.nextInt();
                sum[i] = nums[i] + sum[i - 1];
            }
            if (i == x) {
                num01 = sum[i - 1];
            }
            if (i == y) {
                num02 = sum[i - 1];
            }
        }


        System.out.println(Math.min(sum[n] - (num02 - num01), num02 - num01));

    }

}
