package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/16 15:26
 * @describe 在二维数组中找到目标值
 */
public class BinaryFind {

    public boolean Find(int target, int [][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int row = array.length - 1;
        int col = array[0].length - 1;

        int m = col;
        int n = 0;
        while (m >= 0 && m <= col && n >= 0 && n <= row) {
            if (array[n][m] == target) {
                return true;
            } else if (array[n][m] < target) {
                n += 1;
            } else {
                m -= 1;
            }

        }

        return false;
    }

}
