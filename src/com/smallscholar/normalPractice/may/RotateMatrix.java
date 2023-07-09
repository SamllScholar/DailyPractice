package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 23:48
 * @describe 顺时针旋转90度,首先可以先进行矩阵上三角和下三角根据对角线进行交换, 然后把矩阵的每一个进行翻转,就得到了一个
 * 旋转后的矩阵, 这个方法可能也可以求逆时针旋转矩阵,等等等, 就是找到矩阵对接先以及是上三角和下三角进行交换还是左三角和油三角发生交换
 */
public class RotateMatrix {

    public int[][] rotateMatrix(int[][] mat, int n) {
        int length = mat.length;
        //矩阵转置
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                //交换上三角与下三角对应的元素
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //每行翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][length - j - 1];
                mat[i][length - j - 1] = temp;
            }
        }
        return mat;
    }

}
