package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 0:10
 * @describe 编程入门第20题: 852. 山脉数组的峰顶索引
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
