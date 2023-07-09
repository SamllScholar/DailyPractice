package com.smallscholar.normalPractice.may;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/18 15:20
 * @describe 数组中的逆序对
 */
public class InversePairs {

    public int inversePairs(int [] array) {
        return mergeSortAndCount(array, 0, array.length-1);
    }

    // 归并排序
    private static int mergeSortAndCount(int[] arr, int l, int r)
    {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            count += mergeSortAndCount(arr, l, m);

            count += mergeSortAndCount(arr, m + 1, r);

            count += mergeAndCount(arr, l, m, r);
        }

        return count % 1000000007;
    }

    //合并函数
    private static int mergeAndCount(int[] arr, int l, int m, int r)
    {
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

}
