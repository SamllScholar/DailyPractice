package com.smallscholar.bi.mt.day_8_19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/23 16:16
 * @describe 1、小美的外卖订单编号
 * https://ujimatsu-chiya.github.io/EXAM/Meituan-20230819/#%E5%B0%8F%E7%BE%8E%E7%9A%84%E5%A4%96%E5%8D%96%E8%AE%A2%E5%8D%95%E7%BC%96%E5%8F%B7
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int x = sc.nextInt();

            if (x % m == 0) {
                res.add(m);
            } else {
                res.add(x % m);
            }
        }

        for (Integer re : res) {
            System.out.println(re);
        }
    }

}
