package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/10 10:49
 * @describe 39. 组合总和
 * 心得: 别想多于的优化, 越想越错
 */
public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, target, 0, candidates.length);
        return ans;
    }

    public void backTracking(int[] candidates, int target, int index, int n) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (index >= n || target < 0) {
            return;
        }

        for (int i = index; i < n; i++) {
            temp.add(candidates[i]);
            backTracking(candidates, target - candidates[i], i, n);
            temp.remove(temp.size() - 1);
        }
    }

}
