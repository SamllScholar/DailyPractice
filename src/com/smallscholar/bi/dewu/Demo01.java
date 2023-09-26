package com.smallscholar.bi.dewu;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/24 19:12
 * @describe 1、最少数字
 * https://ujimatsu-chiya.github.io/EXAM/Dewu-20230823/#%E6%9C%80%E5%B0%91%E6%95%B0%E5%AD%97
 */
public class Demo01 {

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bfs(arr, 0, m, 0, 0);
        if (res == Integer.MAX_VALUE) {
            System.out.println("No solution");
        } else {
            System.out.println(res);
        }
    }

    public static void bfs(int[] arr, int index, int m, int sum, int count) {
        if (index > arr.length) {
            return;
        }
        if (sum == m) {
            res = Math.min(res, count);
        }
        for (int i = index; i < arr.length; i++) {
            // 拿当前的
            bfs(arr, i + 1, m, sum + arr[i], count + 1);
            bfs(arr, i + 1, m, sum, count);
        }
    }

}
