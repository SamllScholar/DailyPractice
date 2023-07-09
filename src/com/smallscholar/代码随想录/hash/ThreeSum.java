package com.smallscholar.代码随想录.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 20:54
 * @describe 15. 三数之和
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int index = 0;
        Arrays.sort(nums);

        while (index < n) {
            if (nums[index] > 0){
                break;
            }
            while (index > 0 && index < n && nums[index] == nums[index - 1]) {
                index += 1;
            }
            int left = index + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[index] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[index], nums[left], nums[right]));
                    left += 1;
                    right -= 1;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right -= 1;
                    }
                } else if (sum < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }

            }
            index += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        System.out.println(lists);
    }

}
