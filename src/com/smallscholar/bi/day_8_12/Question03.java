package com.smallscholar.bi.day_8_12;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 14:55
 * @describe 3、小美的蛋糕切割
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230812/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E6%8E%92%E5%88%97%E8%AF%A2%E9%97%AE
 */
public class Question03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
                sum += nums[i][j];
            }
        }
        // 首先按行进行分割
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp += nums[i][j];
            }
            res = Math.min(Math.abs(sum - 2 * temp), res);
        }
        // 然后按列进行分割
        temp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp += nums[j][i];
            }
            res = Math.min(Math.abs(sum - 2 * temp), res);
        }

        System.out.println(res);
    }

}
