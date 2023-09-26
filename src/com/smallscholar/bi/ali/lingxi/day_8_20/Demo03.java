package com.smallscholar.bi.ali.lingxi.day_8_20;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/24 23:20
 * @describe 3、replace
 * https://ujimatsu-chiya.github.io/EXAM/Alilingxihuyu-20230820/#replace
 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if (num > queue.peek()) {
                queue.poll();
                queue.add(num);
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            res += queue.poll();
        }

        System.out.println(res);
    }

}
