package com.smallscholar.programmingBasics;

import sun.applet.Main;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 22:33
 * @describe 编程基础第二十三题：1491. 去掉最低工资和最高工资后的工资平均值
 */
public class Average {

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int j : salary) {
            min = Math.min(min, j);
            max = Math.max(max, j);
            sum += j;
        }

        return  (double) (sum - min - max) / (salary.length - 2);
    }

}
