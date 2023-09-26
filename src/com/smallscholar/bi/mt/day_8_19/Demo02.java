package com.smallscholar.bi.mt.day_8_19;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/23 16:46
 * @describe 2、小美的加法
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230819/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E5%8A%A0%E6%B3%95
 */
public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long sum = nums[0];
        int index = 0;
        long max = 0;
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if ((long) nums[i] * nums[i - 1] > max) {
                index = i - 1;
                max = (long) nums[i] * nums[ i - 1];
            }
        }
        long temp = 0;
        for (int i = 0; i < n; i++) {
            if (index == i) {
                temp += max;
                i += 1;
            } else {
                temp += nums[i];
            }
        }

        System.out.println(Math.max(temp,sum));
    }

}
