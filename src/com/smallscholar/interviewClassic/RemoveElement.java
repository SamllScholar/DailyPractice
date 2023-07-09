package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/1 15:19
 * @describe 面试经典第二题: 27. 移除元素
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int right = nums.length - 1;
        int count = 0;

        for (int i = 0; i <= right; i++) {
            while (i <= right && nums[i] == val) {
                count += 1;
                swap(nums, i, right--);
            }
        }

        return nums.length - count;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5};
        int val = 5;
        int i = new RemoveElement().removeElement(nums, val);
        System.out.println(i);
    }

}
