package com.smallscholar.dailyPractice.may;

import javax.sound.midi.Track;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 8:59
 * @describe 2544. 交替数字和
 */
public class AlternateDigitSum {

    public int alternateDigitSum(int n) {
        int ans = 0;
        int count = 0;
        int num = 0;
        while (n > 0) {
            int temp = n % 10;
            num = num * 10 + temp;
            n /= 10;
        }


        while (num > 0) {
            int temp = num % 10;
            num /= 10;
            if (count++ % 2 == 0) {
                ans += temp;
            } else {
                ans -= temp;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        int i = new AlternateDigitSum().alternateDigitSum(n);
        System.out.println(i);
    }

}
