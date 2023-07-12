package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/10 11:10
 * @describe 40. 组合总和 II
 */
public class CombinationSum2 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, candidates.length, 0);
        return ans;
    }

    public void backTracking(int[] candidates, int target, int n, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (index >= n || target < 0) {
            return;
        }

        for (int i = index; i < n; i++) {
            // 因为是排好序的, 所以,如果当前的解不行的话, 那么之后的解也一定不可以了
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            backTracking(candidates, target - candidates[i], n, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
