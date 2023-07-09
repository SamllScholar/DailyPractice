package com.smallscholar.interviewClassic;

import com.smallscholar.normalPractice.may.RightView;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 8:52
 * @describe 面试经典第十三题: 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    /**
     * 分别计算数组当前元素左右两边的乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;;
        int[] res = new int[n];

        // 计算当前元素左面的乘积和
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        // 获取当前元素的右面的乘积和然后和左边的乘积和相乘
        // right 表示当前元素右边的乘积和, 最右边的一个入用手的乘积和为1
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = nums[i] * right;
        }

        return res;
    }

}
