package com.smallscholar.interviewClassic;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/4 9:38
 * @describe 面试经典第二十九题: 11. 盛最多水的容器
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);
            int temp = 0;

            if (height[left] < height[right]) {
                temp = left;
                while (temp < right && height[temp] <= height[left]) {
                    temp += 1;
                }
                left = temp;
            } else {
                temp = right;
                while (temp > left && height[right] >= height[temp]) {
                    temp -= 1;
                }
                right = temp;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = new MaxArea().maxArea(height);
        System.out.println(i);
    }

}
