package com.smallscholar.代码随想录.binary;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/7 11:04
 * @describe 977. 有序数组的平方
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] ints = new SortedSquares().sortedSquares(nums);
        System.out.println(ints);
    }

}
