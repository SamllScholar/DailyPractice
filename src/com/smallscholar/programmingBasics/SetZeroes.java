package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 21:39
 * @describe 编程基础第二十一题： 73. 矩阵置零
 */
public class SetZeroes {

    /**
     * 使用矩阵的第一行记录对应的列是否有零， 如果有第一行对应的位置就变成1， 使用矩阵的第一列记录某行是否为0， 如果为0
     * 就对应的行就变成0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean r = false;
        boolean c = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                c = true;
                break;
            }
        }

        for (int i = 0; i < m; i++){
            if (matrix[0][i] == 0) {
                r = true;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (r) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if (c){
            for (int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

         int[][] nums = {{0,1}};
        new SetZeroes().setZeroes(nums);
    }


}
