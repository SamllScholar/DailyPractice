package com.smallscholar.bi.huawei.demo01;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 21:19
 * @describe 3、网络升级改造
 *  注意: 如果是满二叉树的话, 他的左子树的索引在2 * i 右子树的索引为 2 * i + 1  --> 这里的索引一定不可以从0开始, 因为这样计算是错误的
 *  https://ujimatsu-chiya.github.io/EXAM/Huawei-20230524/#%E7%BD%91%E7%BB%9C%E5%8D%87%E7%BA%A7%E6%94%B9%E9%80%A0
 */
public class Question03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[2 * n + 2][2];

        for (int i = n; i >= 1; i--) {
            int nextLeft = 2 * i;
            int nextRight = 2 * i + 1;

            dp[i][0] = Math.max(dp[nextLeft][0], dp[nextLeft][1]) + Math.max(dp[nextRight][0], dp[nextRight][1]);
            dp[i][1] = dp[nextLeft][0] + dp[nextRight][0] + arr[i];
        }

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }



}
