package com.smallscholar.bi.jd.day_8_19;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/22 14:27
 * @describe 小红吃药
 * https://ujimatsu-chiya.github.io/EXAM/Jingdong-20230819/#%E5%B0%8F%E7%BA%A2%E5%90%83%E8%8D%AF
 */
public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int n = sc.nextInt();
        int bing = Integer.parseInt(sc.next());
        bing = toBinary(bing);
        int m = sc.nextInt();
        List<Integer> t = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < 2 * m; i++) {
            if (i % 2 == 0) {
                int num = Integer.parseInt(sc.next());
                t.add(toBinary(num));
            } else {
                int num = Integer.parseInt(sc.next());
                p.add(toBinary(num));
            }
        }
        int q = sc.nextInt();
        List<Integer> use = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            use.add(sc.nextInt());
        }

        for (Integer i : use) {
            Integer a = t.get(i - 1);
            Integer b = p.get(i - 1);
            bing = bing | b;
            a = ~a;
            bing = bing & a;
            int count = getCount(bing);
            res.add(count);
        }

        for (Integer re : res) {
            System.out.println(re);
        }

        sc.close();

    }

    public static int toBinary(int num) {
        int res = 0;
        int count = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                res += (int) Math.pow(2, count);
            }
            count += 1;
            num /= 10;
        }
        return res;
    }

    public static int getCount(int bing) {
        int count = 0;
        while (bing != 0) {
            if (bing % 2 == 1){
                count += 1;
            }
            bing = bing >> 1;
        }
        return count;
    }


}
