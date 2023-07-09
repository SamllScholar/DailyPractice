package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 23:35
 * @describe 缺失的第一个正整数
 */
public class MinNumberDisappeared {

    public int minNumberDisappeared (int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 把每一个正整数交换到对应的位置(如果一个数为2, 那么他应该被交换到index = 1的位置)
            // nums[i] > 0保证是正整数, nums[i]小于n保证交换不发生溢出,
            // nums[nums[i] -1] != nums[i]保证对应位置没有正确的数字并且保证不陷入死循环
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
                // 这里不能使用下面的这种方法, 因为不能保证nums[nums[i] - 1]的值小于等于n, 所以要先替换这里面的值
                // int temp = nums[i];
                // nums[i] = nums[nums[i] - 1];
                // nums[nums[i] - 1] = temp;
            }
        }
        // 交换完之后就可以直接从0开始遍历了, 如果0对应的位置不为1, 那么证明之前数组中没有1, 如果有1肯定在前面已经被换过来了
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
