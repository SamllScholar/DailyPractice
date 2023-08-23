package com.smallscholar.bi.mt.day_8_12;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 14:24
 * @describe 1、小美的排列询问
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230812/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E6%8E%92%E5%88%97%E8%AF%A2%E9%97%AE
 */
public class Question01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int y = sc.nextInt();

        int left = 0;
        int right = 1;
        while (right < n) {
            if ((arr[left] == x && arr[right] == y) ||  (arr[left] == y && arr[right] == x)) {
                System.out.println("Yes");
                break;
            }
            left += 1;
            right += 1;
        }

        if (right >= n) {
            System.out.println("No");
        }

    }

}
