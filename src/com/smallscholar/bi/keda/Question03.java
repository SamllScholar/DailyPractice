package com.smallscholar.bi.keda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 20:11
 * @describe 3、科大讯飞机器存储问题
 * https://ujimatsu-chiya.github.io/EXAM/Kedaxunfei-20230813/#%E7%A7%91%E5%A4%A7%E8%AE%AF%E9%A3%9E%E6%9C%BA%E5%99%A8%E5%AD%98%E5%82%A8%E9%97%AE%E9%A2%98
 */
public class Question03 {

    static List<String> res = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr01 = new int[n];
        int[] arr02 = new int[n];

        for (int i = 0; i < n; i++) {
            arr01[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr02[i] = sc.nextInt();
        }

        dfs(arr01, 0, n, new StringBuilder());
        dfs(arr02, 0, n, new StringBuilder());

        System.out.println(res.size());
    }

    public static void dfs(int[] arr, int index, int n, StringBuilder str) {
        if (index >= n) {
            return;
        }

        for (int i = index; i < n; i++) {
            str.append(arr[i]);
            if (set.contains(str.toString())) {
                continue;
            }
            res.add(str.toString());
            set.add(str.toString());
            dfs(arr, i + 1,n,str);
            str.deleteCharAt(str.length() - 1);

            dfs(arr,i + 1, n, new StringBuilder());
        }
    }

}
