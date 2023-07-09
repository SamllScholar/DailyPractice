package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/18 15:31
 * @describe 旋转数组的最小数字
 */
public class MinNumberInRotateArray {

    public int minNumberInRotateArray(int [] array) {
        int n = array.length;
        int min = array[n - 1];
        int i = 0;
        // 排除数组的开头和结尾相同
        while (array[i] == array[n - 1]) {
            i++;
        }

        int left = i;
        int right = n - 1;
        int mid = 0;

        while (left <= right) {
            mid = (right + left) >> 1;
            if (array[mid] <= array[n - 1]) {
                min = Math.min(min, array[mid]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] array = {1, 0, 1, 1, 1};
        int i = new MinNumberInRotateArray().minNumberInRotateArray(array);
        System.out.println(i);
    }

}
