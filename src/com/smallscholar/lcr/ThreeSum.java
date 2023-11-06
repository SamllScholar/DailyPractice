package com.smallscholar.lcr;

import com.smallscholar.bi.xiaomi_09_02.Demo02;
import com.smallscholar.programmingIntroduction.NumIdenticalPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @date 2023/10/27 16:39
 * @version 1.0
 * @describe LCR 007. 三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left += 1;
                    right -= 1;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                } else if (sum < 0){
                    left += 1;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                } else {
                    right -= 1;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                }
            }
        }

        return res;
    }

}
