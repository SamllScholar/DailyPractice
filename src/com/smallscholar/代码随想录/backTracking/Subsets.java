package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/11 18:44
 * @describe 78. 子集
 */
public class Subsets {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return ans;
    }

    public void backTracking(int[] nums, int index) {

        ans.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
