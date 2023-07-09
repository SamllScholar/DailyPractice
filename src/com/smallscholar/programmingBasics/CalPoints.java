package com.smallscholar.programmingBasics;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 14:09
 * @describe 编程基础第十三题: 682. 棒球比赛
 */
public class CalPoints {

    public int calPoints(String[] operations) {
        int res = 0;
        int n = operations.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = list.size();
            if (operations[i].length() > 1 || Character.isDigit(operations[i].charAt(0))) {
                list.add(Integer.parseInt(operations[i]));
            } else if (operations[i].equals("+")) {
                list.add(list.get(m - 1) + list.get(m - 2));
            } else if (operations[i].equals("D")) {
                list.add(2 * list.get(m - 1));
            } else {
                list.remove(m - 1);
            }
        }
        for (Integer integer : list) {
            res += integer;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        int i = new CalPoints().calPoints(ops);
        System.out.println(i);
    }

}
