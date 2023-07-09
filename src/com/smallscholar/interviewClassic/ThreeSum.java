package com.smallscholar.interviewClassic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/4 9:50
 * @describe 面试经典第三十题: 15. 三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int index = 0;
        int n = nums.length;

        while (index < n - 2) {
            if (nums[index] > 0) {
                break;
            }
            if (index > 0 && nums[index] == nums[index - 1]) {
                index += 1;
                continue;
            }
            int left = index + 1;
            int right = n - 1;
            while (left < right){
                int sum = nums[index] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[index],nums[left],nums[right]));
                    left += 1;
                    right -= 1;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    left += 1;
                }
            }
            index += 1;
        }

        return res;
    }

}
