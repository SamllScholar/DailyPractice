package com.smallscholar.bi.dewu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/24 19:53
 * @describe 2、开幕式排练
 * https://ujimatsu-chiya.github.io/EXAM/Dewu-20230823/#%E5%BC%80%E5%B9%95%E5%BC%8F%E6%8E%92%E7%BB%83
 */
public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        if (n == 2) {
            res = arr[1] - arr[0];
        } else {
            for (int i = 2; i < n; i++) {
                res = Math.min(res, arr[i] - arr[i - 2]);
            }
        }

        System.out.println(res);

    }

}
