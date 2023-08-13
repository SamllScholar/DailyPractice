package com.smallscholar.bi.huawei.demo01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 20:34
 * @describe 1、连续空闲内存合并管理
 *  https://ujimatsu-chiya.github.io/EXAM/Huawei-20230524/#%E8%BF%9E%E7%BB%AD%E7%A9%BA%E9%97%B2%E5%86%85%E5%AD%98%E5%90%88%E5%B9%B6%E7%AE%A1%E7%90%86
 */
public class Question01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start = 0;
        int maxLen = 0;

        int left = 0;
        int right = 1;
        while (right < n) {
            if (arr[right] - arr[right - 1] == 1) {
                int len = right - left + 1;
                if (len > maxLen) {
                    start = arr[left];
                    maxLen = len;
                }
            } else {
                left = right;
            }

            right += 1;

        }

        System.out.println(start);
        System.out.println(maxLen);

    }

}
