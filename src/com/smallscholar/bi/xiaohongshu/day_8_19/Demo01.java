package com.smallscholar.bi.xiaohongshu.day_8_19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/23 12:51
 * @describe 1、小红背单词
 * https://ujimatsu-chiya.github.io/EXAM/Xiaohongshu-20230819/#%E5%B0%8F%E7%BA%A2%E8%83%8C%E5%8D%95%E8%AF%8D
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            list.add(str);
            hashMap.put(str, hashMap.getOrDefault(str, 0) + 1);
        }

        for (int i = 0; i < list.size(); i++) {
            Integer count = hashMap.get(list.get(i));
            if (count == i + 1) {
                res++;
            }
        }

        System.out.println(res);
    }

}
