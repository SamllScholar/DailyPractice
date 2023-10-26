package com.smallscholar.random;

import javax.sql.rowset.serial.SQLOutputImpl;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author smallscholar
 * @date 2023/10/25 21:30
 * @version 1.0
 * @describe ...
 */
public class MinimumSum {

    public int minimumSum(int num) {
        int[] nums = new int[4];
        nums[0] = num % 10;
        nums[1] = num / 10 % 10;
        nums[2] = num / 100 % 10;
        nums[3] = num / 1000 % 10;
        Arrays.sort(nums);

        return (nums[0] * 10 + nums[2]) + (nums[1] * 10 + nums[3]);
    }

    public static void main(String[] args) {
        int num = 2932;

        int i = new MinimumSum().minimumSum(num);
        System.out.println(i);
    }

}
