package com.smallscholar.normalPractice.may;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 23:30
 * @describe ...
 */
public class SpiralOrder {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {//这个必须放前面
            return list;
        }
        if (matrix == null || matrix[0].length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int count = (Math.min(m, n) + 1) / 2;
        while (i < count) {
            for (int j = i; j < (n - i); j++) {//从左到右  第一行不变，列变
                list.add(matrix[i][j]);
            }
            for (int j = i + 1; j < (m - i); j++) {//从上到下  行变，最后一列不变
                list.add(matrix[j][(n - 1) - i]);
            }
            for (int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); j--) {//从右到左，最后一行不变，列变
                list.add(matrix[(m - 1) - i][j]);
            }
            for (int j = (m - 1) - (i + 1); j >= i + 1 && (n - 1 - i) != i; j--) {//从下到上，行变列不变
                list.add(matrix[j][i]);

            }
            i++;

        }
        return list;

    }

}
