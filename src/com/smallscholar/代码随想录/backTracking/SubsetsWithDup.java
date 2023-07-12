package com.smallscholar.代码随想录.backTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/11 23:33
 * @describe 90. 子集 II
 */
public class SubsetsWithDup {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTracking(nums,0);
        return ans;
    }

    public void backTracking(int[] nums, int index) {
        ans.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            backTracking(nums,i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
