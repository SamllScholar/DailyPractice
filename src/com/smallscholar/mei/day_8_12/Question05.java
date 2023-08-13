package com.smallscholar.mei.day_8_12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 15:45
 * @describe 5、小美的树上染色
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230812/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E6%A0%91%E4%B8%8A%E6%9F%93%E8%89%B2
 */
public class Question05 {

    static List<Integer> list = null;
    static int res = 0;

    public static void main(String[] args) {
        List<List<Integer>> map = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList<>();
        list.add(-1);
        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }

        for (int i = 0; i < n - 1; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (!isSquare(list.get(num1) * list.get(num2))) {
                continue;
            }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(num1);
            list.add(num2);
            map.add(list);
        }

        dfs(map, new HashSet<>(), 0, map.size());

        System.out.println(res);
    }

    public static void dfs(List<List<Integer>> map, HashSet<Integer> used, int index, int n) {
        if (index >= map.size()) {
            res = Math.max(used.size(), res);
            return;
        }

        for (int i = index; i < n; i++) {
            List<Integer> nodes = map.get(i);
            int num1 = nodes.get(0);
            int num2 = nodes.get(1);
            if (used.contains(num1) || used.contains(num2)) {
                continue;
            }
            used.add(num1);
            used.add(num2);
            dfs(map, used, i + 1, n);
            used.remove(num1);
            used.remove(num2);
            dfs(map, used, i + 1, n);
        }
    }

    public static boolean isSquare(int num) {
        double a = Math.sqrt(num);
        int b = (int) a;
        return a - b == 0;
    }

}
