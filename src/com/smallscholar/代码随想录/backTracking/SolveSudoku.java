package com.smallscholar.代码随想录.backTracking;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 11:32
 * @describe 37. 解数独
 */
public class SolveSudoku {

    boolean flag = false;
    public void solveSudoku(char[][] board) {
        backTracking(board,0, 0);
    }

    public void backTracking(char[][] board, int m, int n) {
        // 证明得到了唯一的解
        if (m >= 9 && n >= 9) {
            flag = true;
            return;
        }
        if (n >= 9) {
            n = 0;
            m += 1;
        }

        if (board[m][n] == '.' && !flag) {
            for (int k = 1; k < 10; k++) {
                board[m][n] = (char) k;
                if (isValidSudoku(board)) {
                    backTracking(board, m, n + 1);
                }
            }
        }
    }


    public boolean isValidSudoku(char[][] board) {
        //定义数字行内出现的次数
        int[][] row = new int[9][9];
        //定义数字列内出现的次数
        int[][] column = new int[9][9];
        //定义数字九宫格内出现的次数最大为9次
        int[][][] jiugongge = new int[3][3][9];
        //遍历数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                //只要存在数字
                if (c != '.') {
                    //把数独中的数字转换成对应数组中的下标, 如果不减一会出现9这样就溢出了
                    int index = c - '1';
                    // 如果对应的行出现了某个元素, 那么对应行中该元素对应的索引加一
                    row[i][index]++;
                    //列同理
                    column[j][index]++;
                    //并且九宫格内次数也要+1,例如也是第1行第一列，i/3 j/3会自动定位到所在的小宫格
                    jiugongge[i / 3][j / 3][index]++;
                    // 如果三个二维数组中某个元素出现的次数大于1, 证明不合法, 直接返回false
                    if (row[i][index] > 1 || column[j][index] > 1 || jiugongge[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
