package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 0:02
 * @describe 46. 全排列
 */
public class Permute {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return ans;
    }

    public void  backTracking(int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            set.add(nums[i]);
            backTracking(nums);
            temp.remove(temp.size() - 1);
            set.remove(nums[i]);
        }
    }

}
