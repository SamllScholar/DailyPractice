package com.smallscholar.newStart.september;

import com.smallscholar.normalPractice.may.Temp;
import com.smallscholar.normalPractice.may.TwoSum;
import com.sun.media.sound.SoftTuning;

/**
 * @author smallscholar
 * @date 2023/9/26 12:40
 * @version 1.0
 * @describe lc: 2582. 递枕头
 */
public class Day_26 {
    public int passThePillow(int n, int time) {
        if (time < n) {
            return time + 1;
        }
        int temp = time % (2 * (n - 1));
        return temp < n ? temp + 1 : (2 * (n - 1) - temp) + 1;
    }

    public static void main(String[] args) {
        int n = 4;
        int time = 5;

        int i = new Day_26().passThePillow(n, time);
        System.out.println(i);

    }

}
