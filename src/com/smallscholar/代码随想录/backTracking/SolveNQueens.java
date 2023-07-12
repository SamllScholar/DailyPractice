package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 9:18
 * @describe 51. N 皇后
 */
public class SolveNQueens {

    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return ans;
        }
        //record是长度为n的一维数组，脚标代表行数，里面的值代表第几列放置了皇后
        int[] record = new int[n];
        backTracking(0, record, n);
        return ans;
    }

    public void backTracking(int i, int[] record, int n) {
        if (i == n || temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = 0; j < n; j++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            if (isValid(record, i, j)) {
                record[i] = j;
                row[j] = 'Q';
                temp.add(new String(row));
                backTracking(i + 1, record, n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                //左边代表不能在同一列||右边代表等边三角形两个直角边相等长度 在斜线上
                return false;
            }
        }
        return true;
    }

}
