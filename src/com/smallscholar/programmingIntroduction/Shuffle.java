package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 23:38
 * @describe 变成入门第16题: 1470. 重新排列数组
 */
public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int index = 0;
        for (int i = 0, j = n; i < n; i ++) {
            res[index++] = nums[i];
            res[index++] = nums[j++];
        }
        return res;
    }

}
