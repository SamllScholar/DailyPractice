package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 23:23
 * @describe 牛客: 旋转数组
 */
public class ReverseArr {

    // 先对整合数组进行翻转, 然后分别对两个局部进行翻转, 这样就得到了旋转后的数组
    public int[] solve (int n, int m, int[] a) {
        // m可能很多,所以要对n进行取值
        int len = m % n;
        reverse(a, 0, n - 1);
        reverse(a, 0, len - 1);
        reverse(a, len, n - 1);
        return a;
    }

    public void reverse(int[] a, int left, int right) {
        while (left < right) {
            int temp = a[left];
            a[left++] = a[right];
            a[right--] = temp;
        }
    }

}
