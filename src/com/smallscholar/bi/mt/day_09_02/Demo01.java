package com.smallscholar.bi.mt.day_09_02;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/9/2 19:01
 * @describe ...
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] b = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            b[i] = arr[i + 1] - arr[i];
        }
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i] - 1) {
                flag = false;
                break;
            }
            if (b[i] >= b[i - 1]) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "Yes" : "No");
    }

}
