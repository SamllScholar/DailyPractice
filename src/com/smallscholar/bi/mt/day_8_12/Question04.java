package com.smallscholar.bi.mt.day_8_12;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 15:04
 * @describe 4、小美的字符串变换
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230812/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%8F%98%E6%8D%A2
 */
public class Question04 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                int minArea = getMinArea(str, i, n / i);
                res = Math.min(minArea, res);
            }
        }

        System.out.println(res);
    }

    static char[][] chars = null;

    public static int getMinArea(String str, int x, int y) {
        initChars(str, x, y);
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (chars[i][j] != '0') {
                    dfs(chars, chars[i][j], x, y, i, j);
                    count += 1;
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] chars, char target, int x, int y, int i, int j) {
        chars[i][j] = '0';
        if (i + 1 < x && chars[i + 1][j] == target) {
            dfs(chars, target, x, y, i + 1, j);
        }
        if (i - 1 >= 0 && chars[i - 1][j] == target) {
            dfs(chars, target, x, y, i - 1, j);
        }
        if (j + 1 < y && chars[i][j + 1] == target) {
            dfs(chars, target, x, y, i, j + 1);
        }
        if (j - 1 >= 0 && chars[i][j - 1] == target) {
            dfs(chars, target, x, y, i, j - 1);
        }
    }

    public static void initChars(String str, int x, int y) {
        char[] charArray = str.toCharArray();
        chars = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                chars[i][j] = charArray[i * y + j];
            }
        }
    }

}
