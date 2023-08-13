package com.smallscholar.bi.keda;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 19:52
 * @describe 1、最大优美排列
 * https://ujimatsu-chiya.github.io/EXAM/Kedaxunfei-20230813/#%E6%9C%80%E5%A4%A7%E4%BC%98%E7%BE%8E%E6%8E%92%E5%88%97
 */
public class Question01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder str = new StringBuilder();
        for(int i = n; i >0; i--) {
            if (i == 1) {
                str.append(i);
            } else {
                str.append(i).append(" ");
            }
        }

        System.out.println(str.toString());
    }

}
