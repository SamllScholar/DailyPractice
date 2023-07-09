package com.smallscholar.normalPractice.may;


/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 14:43
 * @describe 盛水最多的容器
 */
public class MaxAreaForContent {

    public int maxArea(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int area = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                int temp = left + 1;
                while (temp < right && height[left] >= height[temp]) {
                    temp += 1;
                }
                left = temp;
            } else {
                int temp = right - 1;
                while (left < temp && height[right] >= height[temp]) {
                    temp -= 1;
                }
                right = temp;
            }
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
        }
        return area;
    }

    public static void main(String[] args) {
        int[] height = {6,4,3,1,4,6,99,62,1,2,6};
        int maxArea = new MaxAreaForContent().maxArea(height);
        System.out.println(maxArea);
    }

}
