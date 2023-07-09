package com.smallscholar.programmingBasics;

import sun.applet.resources.MsgAppletViewer_ja;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 15:51
 * @describe 编程基础第二十题: 54. 螺旋矩阵
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null ||  matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m - 1;
        int up = 0;
        int down = n - 1;

        while (left <= right && up <= down) {
            for (int c = left; c <= right; c++){
                list.add(matrix[up][c]);
            }
            for (int r = up + 1; r <= down; r++) {
                list.add(matrix[r][right]);
            }
            if (left < right && up < down) {
                for (int c = right - 1; c > left; c--) {
                    list.add(matrix[down][c]);
                }
                for (int r = down; r > up; r--) {
                    list.add(matrix[r][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {6, 7, 8, 9}, {11, 12, 13, 14}, {16, 17, 18, 19}};
        List<Integer> list = new SpiralOrder().spiralOrder(matrix);
        System.out.println(list);
    }

}
