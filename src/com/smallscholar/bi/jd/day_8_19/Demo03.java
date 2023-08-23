package com.smallscholar.bi.jd.day_8_19;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/22 15:14
 * @describe 3、小红的皇后
 * https://ujimatsu-chiya.github.io/EXAM/Jingdong-20230819/#%E5%B0%8F%E7%BA%A2%E7%9A%84%E7%9A%87%E5%90%8E
 */
public class Demo03 {

    static int res = Integer.MAX_VALUE;
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] cheers = new char[n][m];
        for (int i = 0; i < n; i++) {
            cheers[i] = sc.next().toCharArray();
        }
        if (m == 1 && n == 1) {
            System.out.println(0);
        } else {
            bfs(cheers, 0, 1, 0, 0);
            bfs(cheers, 1, 1, 0, 0);
            bfs(cheers, 2, 1, 0, 0);
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);
        }
        sc.close();
    }

    public static void bfs(char[][] cheers, int dir, int count, int i, int j) {
        if (i >= n || j >= m) {
            return;
        }
        if (i == n - 1 && j == m - 1) {
            res = Math.min(res, count);
            return;
        }

        // 尝试向右走
        if (j < m - 1 && cheers[i][j + 1] != '*') {
            if (dir == 0) {
                bfs(cheers, dir, count, i, j + 1);
            } else {
                bfs(cheers, 0, count + 1, i, j + 1);
            }
        }

        // 尝试向右下走
        if (i < n - 1 && j < m - 1 && cheers[i + 1][j + 1] != '*') {
            if (dir == 2) {
                bfs(cheers, dir, count, i + 1, j + 1);
            } else {
                bfs(cheers, 2, count + 1, i + 1, j + 1);
            }
        }
        // 尝试向下走
        if (i < n - 1 && cheers[i + 1][j] != '*') {
            if (dir == 1) {
                bfs(cheers, dir, count, i + 1, j);
            } else {
                bfs(cheers, 1, count + 1, i + 1, j);
            }
        }
    }

}
