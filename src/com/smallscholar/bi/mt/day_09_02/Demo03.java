package com.smallscholar.bi.mt.day_09_02;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/9/2 19:34
 * @describe ...
 */
public class Demo03 {

    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n != 1) {
            int one = nums[0];
            int FirMax = nums[1];
            int SecMax = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] > FirMax) {
                    SecMax = FirMax;
                    FirMax = nums[i];
                }
            }
            res += getDivCount(FirMax, SecMax);
            res += getMulCount(one,SecMax);

            int max = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            res = Math.min(res, getMulCount(one,max));
        }

        System.out.println(res);

    }

    public static int getMulCount(int a, int b) {
        int count = 0;
        while (a < b) {
            count += 1;
            a *= 2;
        }
        return count;
    }

    public static int getDivCount(int a, int b) {
        int count = 0;
        if (a > b) {
            a /= 2;
            count += 1;
        }
        return count;
    }

}
