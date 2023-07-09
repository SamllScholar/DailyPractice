package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 15:17
 * @describe 二分查找
 */
public class BinarySearch {

    public int search (int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
     }

    public static void main(String[] args) {
        int[] nums = {-1, 1};
        int search = new BinarySearch().search(nums, -1);
        System.out.println(search);
    }

}
