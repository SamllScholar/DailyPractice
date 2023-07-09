package com.smallscholar.interviewClassic;

import com.smallscholar.normalPractice.may.TreeNode;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 18:15
 * @describe 面试经典第四题: 80. 删除有序数组中的重复项 II
 */
public class RemoveDuplicatesTwo {

    public int removeDuplicates(int[] nums) {
        int slow = 1;
        int n = nums.length;
        boolean flag = true;

        for (int fast = 1; fast < n; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
                flag = true;
            } else if (nums[fast] == nums[fast - 1] && flag){
                nums[slow++] = nums[fast];
                flag = false;
            }
        }

        return slow;
    }

}
