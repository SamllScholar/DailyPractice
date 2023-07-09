package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 12:38
 * @describe 编程基础第十题: 896. 单调数列
 */
public class IsMonotonic {

    public boolean isMonotonic(int[] nums) {
        int flag = 0;
        // 判断是否是单调递增
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                flag++;
            } else {
                break;
            }
        }
        if (flag == nums.length - 1) {
            return true;
        }
        flag = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] <= nums[i - 1]) {
                flag++;
            } else {
                break;
            }
        }

        return flag == nums.length - 1;
    }

    public boolean isMonotonic01(int[] nums) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]){
                inc = false;
                break;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                dec = false;
                break;
            }
        }

        return inc | dec;
    }

}
