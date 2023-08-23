package com.smallscholar.bi.jd.day_8_19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/22 13:57
 * @describe 1、小红的夹吃棋
 * https://ujimatsu-chiya.github.io/EXAM/Jingdong-20230819/#%E5%B0%8F%E7%BA%A2%E7%9A%84%E5%A4%B9%E5%90%83%E6%A3%8B
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            boolean wightWin = false;
            boolean blackWin = false;
            char[][] chars = new char[3][3];
            for (int j = 0; j < 3; j++) {
                String str = sc.next();
                chars[j][0] = str.charAt(0);
                chars[j][1] = str.charAt(1);
                chars[j][2] = str.charAt(2);
            }
            // 对行和列进行判断看是是否有赢的情况
            for (int j = 0; j < 3; j++) {
                if (chars[j][0] == '.' || chars[j][1] == '.' || chars[j][2] == '.') {
                    continue;
                }
                if (chars[j][0] == '*' && chars[j][1] == 'o' && chars[j][2] == '*') {
                    blackWin = true;
                }
                if (chars[j][0] == 'o' && chars[j][1] == '*' && chars[j][2] == 'o') {
                    wightWin = true;
                }
            }
            for (int j = 0; j < 3; j++) {
                if (chars[0][j] == '.' || chars[1][j] == '.' || chars[2][j] == '.') {
                    continue;
                }
                if (chars[0][j] == '*' && chars[1][j] == 'o' || chars[2][j] == '*') {
                    blackWin = true;
                }
                if (chars[0][j] == 'o' && chars[1][j] == '*' && chars[2][j] == 'o') {
                    wightWin = true;
                }
            }
            if (blackWin && !wightWin) {
                res.add("kou");
            } else if (!blackWin && wightWin) {
                res.add("yukari");
            } else {
                res.add("draw");
            }

        }

        for (String re : res) {
            System.out.println(re);
        }
        sc.close();
    }

}
