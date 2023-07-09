package com.smallscholar.normalPractice.may;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 21:52
 * @describe ...
 */
public class FindKth {

    public int findKth(int[] a, int n, int K) {
        Arrays.sort(a);

        return a[n - K];
    }

    public static void main(String[] args) {
        int[] a= {10,10,9,9,8,7,5,6,4,3,4,2};
        int kth = new FindKth().findKth(a, 12, 6);
        System.out.println(kth);
    }

}
