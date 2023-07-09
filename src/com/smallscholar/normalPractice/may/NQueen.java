package com.smallscholar.normalPractice.may;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 9:30
 * N皇后问题
 * 两个要点:
 * 1. 需要使用一个额外的1维数组来保存之前的皇后占用的行列的信息, 这个数组的索引代表了皇后在第几行, 这个数组索引的内容在代表了
 * 皇后在第几列 如record[0] = 1, 表示了第0个皇后在1列(索引从0开始)
 * 2. 使用一个函数判断当前皇后的位置是否合法
 */
public class NQueen {

    public int nQueen(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];
        return dfs(record, n, 0);
    }

    /**
     * 打表法
     * @param n
     * @return
     */
    public int Nqueen(int n) {
        if (n < 1) {
            return 0;
        }
        int[] num = new int[]{1, 0, 0, 2, 10, 40, 92, 352};
        return num[n - 1];
    }

    public int dfs(int[] record, int n, int cur) {
        if (cur == n) {
            return 1;
        }
        int res = 0;
        // 遍历当前行, 找到所有满足条件的皇后的位置
        for (int i = 0; i < n; i++) {
            if (isValid(record, i, cur)) {
                record[cur] = i;
                res += dfs(record, n, cur + 1);
            }
        }
        return res;
    }
    public boolean isValid(int[] record, int col, int cur) {
        // 遍历之前的每一个行的皇后和当前的行的进行判断,看看当前的皇后是否合法
        for (int row = 0; row < cur; row++) {
            // 前面的判断,两个皇后是否在同一列, 后面的是判断两个皇后是否在同一斜线上, 如果在的话那么行 - 行的绝对值一定等于
            // 列 - 列的绝对值
            if (record[row] == col || Math.abs(record[row] - col) == Math.abs(cur - row)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] num = new int[9];
        for (int i = 1; i <= num.length; i++) {
            num[i - 1] = new NQueen().nQueen(i);
        }
        System.out.println(Arrays.toString(num));
    }

}
