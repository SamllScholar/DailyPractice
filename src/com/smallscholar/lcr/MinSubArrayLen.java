package com.smallscholar.lcr;

import com.smallscholar.代码随想录.greedy.LemonadeChange;
import org.omg.CORBA.IRObject;

import java.util.List;

/**
 * @author smallscholar
 * @date 2023/10/27 16:54
 * @version 1.0
 * @describe ...
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int n = nums.length;

        int left = 0;
        int right = 0;
        int sum = 0;

        while (left <= right && right < n) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }

            right += 1;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1,4,4};
        int i = new MinSubArrayLen().minSubArrayLen(target, nums);
        System.out.println(i);
    }

}
