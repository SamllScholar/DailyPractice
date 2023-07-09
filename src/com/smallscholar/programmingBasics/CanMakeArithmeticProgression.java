package com.smallscholar.programmingBasics;

import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 11:27
 * @describe 编程基础第九题: 1502. 判断能否形成等差数列
 */
public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        float d = 0;
        for (int j : arr) {
            min = Math.min(min, j);
            max = Math.max(max, j);
            sum += j;
        }
        if (min == max) {
            return true;
        }
        d = (float) ((max - min) / (n - 1));
        if (Math.round(d) != d) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add((int) (min + d * i));
            temp.add(arr[i]);
        }

        for (int i : arr) {
            if (!set.contains(i)) {
                return false;
            }
        }

        return temp.size() == set.size();
    }


    public static void main(String[] args) {
        int[] nums = {1,2,2,5,5};
        boolean b = new CanMakeArithmeticProgression().canMakeArithmeticProgression(nums);
        System.out.println(b);
    }

}
