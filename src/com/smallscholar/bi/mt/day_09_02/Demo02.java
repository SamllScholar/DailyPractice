package com.smallscholar.bi.mt.day_09_02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/9/2 19:11
 * @describe ...
 */
public class Demo02 {

    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n < 7) {
            System.out.println("NO");
        } else {
            HashSet<Character> set = new HashSet<>();
            set.add('m');
            set.add('e');
            set.add('i');
            set.add('t');
            set.add('u');
            set.add('a');
            set.add('n');
            char[][] chars = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < str.length(); j++) {
                    chars[i][j] = str.charAt(j);
                }

            }

            bfs(chars, 0, 0, set, m, n);
            System.out.println(flag ? "YES" : "NO");

        }
    }

    public static void bfs(char[][] chars, int i, int j, Set<Character> set, int m, int n) {
        if (set.isEmpty()) {
            flag = true;
            return;
        }
        if (flag || i >= n || j >= m) {
            return;
        }

        for (int k = j; k < m; k++) {
            char ch = chars[i][j];
            if (set.contains(ch)) {
                set.remove(ch);
                bfs(chars, i + 1, 0, set, m, n);
                set.add(ch);

                bfs(chars, i, k + 1, set, m, n);
            }
//            if (j == m - 1) {
//                bfs(chars, i + 1, 0, set, m, n);
//            }
        }

    }


}
