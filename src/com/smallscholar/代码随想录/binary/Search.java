package com.smallscholar.代码随想录.binary;

import javax.sound.midi.MidiChannel;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 10:54
 * @describe lc:704. 二分查找
 */
public class Search {

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
