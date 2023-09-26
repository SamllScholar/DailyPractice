package com.smallscholar.bi.ali.lingxi.day_8_20;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/24 23:49
 * @describe 4、world
 * https://ujimatsu-chiya.github.io/EXAM/Alilingxihuyu-20230820/#world
 */
public class Demo04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int[][] a = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = sc.nextInt();
                }
            }
            int res = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (a[j][k] <= x) {
                        res += 1;
                        bfs(a, j, k, n, m, x);
                    }
                }
            }

            list.add(res == 0 ? "Orz" : res + "");
        }

        for (String s : list) {
            System.out.println(s);
        }

    }

    public static void bfs(int[][] a, int i, int j, int n, int m, int x) {
        if (i >= n || j >= m) {
            return;
        }
        if (i < n - 1 && a[i + 1][j] <= x) {
            a[i + 1][j] = x + 1;
            bfs(a, i + 1, j, n, m, x);
        }
        if (i > 0 && a[i - 1][j] <= x) {
            a[i - 1][j] = x + 1;
            bfs(a, i - 1, j, n, m, x);
        }
        if (j < m - 1 && a[i][j + 1] <= x) {
            a[i][j + 1] = x + 1;
            bfs(a, i, j + 1, n, m, x);
        }
        if (j > 0 && a[i][j - 1] <= x) {
            a[i][j - 1] = x + 1;
            bfs(a, i, j - 1, n, m, x);
        }
    }


}
