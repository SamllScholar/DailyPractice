package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/20 14:30
 * @describe 合并两个有序数组
 */
public class MergeOrderArray {

    public void merge(int A[], int m, int B[], int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int ppp = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = B[p2--];
            } else if (p2 == -1) {
                cur = A[p1--];
            } else if (A[p1] > B[p2]) {
                cur = A[p1--];
            } else {
                cur = B[p2--];
            }
            A[ppp--] = cur;
        }
    }


    public static void main(String[] args) {
        int[] A = {0};
        int[] B = {1};
        new MergeOrderArray().merge(A, 0, B, 1);
    }

}
