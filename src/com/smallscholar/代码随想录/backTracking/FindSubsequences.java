package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/11 23:40
 * @describe 491. 递增子序列
 */
public class FindSubsequences {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return ans;
    }

    public void backTracking(int[] nums, int index) {
        if (temp.size() >= 2) {
            ans.add(new ArrayList<>(temp));
        }
        // 使用set进行去重, 因为没有进行排序, 所以不可以使用 num[i] == num[i - 1]进行去重
        // 我们可以使用一个set, 如果当前的这一层循环遍历了一个元素, 我们就把这个元素添加到set, 如果后面出现
        // 这个元素就不用考虑了, 当然如果是更深一层的话还是要考虑的
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (temp.size() > 0 && nums[i] < temp.get(temp.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);

            temp.add(nums[i]);
            backTracking(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
