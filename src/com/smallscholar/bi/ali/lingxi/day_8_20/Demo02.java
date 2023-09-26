package com.smallscholar.bi.ali.lingxi.day_8_20;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/24 23:09
 * @describe 2、rank
 * https://ujimatsu-chiya.github.io/EXAM/Alilingxihuyu-20230820/#rank
 */
public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : arr) {
            if (!queue.contains(num)) {
                if (queue.size() < 3) {
                    queue.add(num);
                } else {
                    if (num > queue.peek()) {
                        queue.poll();
                        queue.add(num);
                    }
                }
            }
        }
        int res = 0;
        if (queue.size() < 3) {
            while (!queue.isEmpty()) {
                res = queue.poll();
            }
            System.out.println(res);
        } else {
            System.out.println(queue.peek());
        }
    }

}
