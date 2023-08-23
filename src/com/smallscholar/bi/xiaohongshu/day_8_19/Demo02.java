package com.smallscholar.bi.xiaohongshu.day_8_19;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/23 12:59
 * @describe 2、小红的回文串
 * https://ujimatsu-chiya.github.io/EXAM/Xiaohongshu-20230819/#%E5%B0%8F%E7%BA%A2%E7%9A%84%E5%9B%9E%E6%96%87%E4%B8%B2
 */
public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<String> res = new ArrayList<>();
        for (int n = 0; n < t; n++) {
            String s = sc.next();
            s = s.replaceAll("w", "vv").replaceAll("m", "nn");
            s = s.replaceAll("b", "0").replaceAll("p", "0").replaceAll("d", "0").replaceAll("q", "0");
            s = s.replaceAll("n", "1").replaceAll("u", "0");
            String str = new StringBuilder(s).reverse().toString();
            if (s.equals(str)) {
                res.add("Yes");
            } else {
                res.add("No");
            }
        }

        for (String re : res) {
            System.out.println(re);
        }
    }

}
