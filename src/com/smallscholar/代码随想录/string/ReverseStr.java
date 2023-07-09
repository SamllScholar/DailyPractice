package com.smallscholar.代码随想录.string;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 21:50
 * @describe 541. 反转字符串 II
 */
public class ReverseStr {


    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }


}
