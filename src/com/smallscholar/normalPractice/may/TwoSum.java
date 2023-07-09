package com.smallscholar.normalPractice.may;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 22:28
 * @describe ...
 */
public class TwoSum {

    public int[] twoSum (int[] numbers, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                res[0] = hashMap.get(target - numbers[i]) + 1;
                res[1] = i + 1;
            }

            hashMap.put(numbers[i], i);
        }

        return  res;

    }

    public static void main(String[] args) {
        int[] numbers = {3, 2, 4};
        int[] ints = new TwoSum().twoSum(numbers, 6);
        System.out.println();
    }

}
