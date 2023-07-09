package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 15:33
 * @describe 面试经典第三题: 26. 删除有序数组中的重复项
 */
public class RemoveDuplicates {

    /**
     * 做之前盲猜一手双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slow = 1;
        int n = nums.length;;

        for (int fast = 1; fast < n; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }

        return slow;
    }

}
