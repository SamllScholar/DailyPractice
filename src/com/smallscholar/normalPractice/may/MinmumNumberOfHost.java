package com.smallscholar.normalPractice.may;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 18:16
 * @describe ...
 */
public class MinmumNumberOfHost {

    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // write code here
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(start[i] >= end[j])
                j++;
            else
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] startEnd = {{1, 2}, {2, 3}};
        int i = new MinmumNumberOfHost().minmumNumberOfHost(n, startEnd);
        System.out.println(i);
    }

}
