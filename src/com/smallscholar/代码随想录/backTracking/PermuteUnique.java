package com.smallscholar.代码随想录.backTracking;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.*;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 0:14
 * @describe ...
 */
public class PermuteUnique {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }

        backTracking(nums,hashMap);
        return ans;
    }

    public void backTracking(int[] nums, HashMap<Integer, Integer> hashMap) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int count = hashMap.get(nums[i]) - 1;
            if (count < 0) {
                continue;
            }
            temp.add(nums[i]);
            hashMap.put(nums[i], hashMap.get(nums[i]) - 1);
            backTracking(nums,hashMap);
            temp.remove(temp.size() - 1);
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
    }

}
