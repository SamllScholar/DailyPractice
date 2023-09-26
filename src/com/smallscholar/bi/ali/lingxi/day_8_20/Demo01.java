package com.smallscholar.bi.ali.lingxi.day_8_20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/24 22:56
 * @describe 1、prime
 * https://ujimatsu-chiya.github.io/EXAM/Alilingxihuyu-20230820/#prime
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int[] chars = new int[26];
            char[] array = s.toCharArray();
            int max = 0;
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                int index = array[j] - 'a';
                chars[index]++;
                max = count < chars[index] ? index : max;
                count = chars[index];
            }
            res.add(isPrim(max) ? "Yes" : "No");
        }

        for (String re : res) {
            System.out.println(re);
        }
    }

    public static boolean isPrim(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }

}
