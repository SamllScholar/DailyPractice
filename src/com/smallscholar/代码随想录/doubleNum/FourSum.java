package com.smallscholar.代码随想录.doubleNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:12
 * @describe 18. 四数之和
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0  && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long)nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
                continue;
            }
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left += 1;
                        right -= 1;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left += 1;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right -= 1;
                        }
                    } else if (target > sum) {
                        left += 1;
                    } else {
                        right -= 1;
                    }
                }
            }
        }

        return ans;
    }

}
