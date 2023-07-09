package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 11:07
 * 矩阵最长递增路径: 类似于岛屿问题, 但是要额外使用一个额外的数组来判断当前的路径有没有被访问过, 如果没访问过就不在进行访问了
 * 和岛屿问题一样,分四个方向进行递归, 如果可以走那么就进行递归
 */
public class SolveSolve {

    int res = 0;

    public int solve(int[][] matrix) {
        if (matrix.length != 0 && matrix[0].length != 0) {
            boolean[][] flag = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    flag[i][j] = true;
                    dfs(matrix, i, j, 1, flag);
                    flag[i][j] = false;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] matrix, int m, int n, int max, boolean[][] flag) {
        res = Math.max(max, res);

        if (m > 0 && matrix[m - 1][n] > matrix[m][n] && !flag[m - 1][n]) {
            flag[m - 1][n] = true;
            dfs(matrix, m - 1, n, max + 1, flag);
            flag[m - 1][n] = false;
        }
        if (m < matrix.length - 1 && matrix[m + 1][n] > matrix[m][n] && !flag[m + 1][n]) {
            flag[m + 1][n] = true;
            dfs(matrix, m + 1, n, max + 1, flag);
            flag[m + 1][n] = false;
        }
        if (n > 0 && matrix[m][n - 1] > matrix[m][n] && !flag[m][n - 1]) {
            flag[m][n - 1] = true;
            dfs(matrix, m, n - 1, max + 1, flag);
            flag[m][n - 1] = false;
        }
        if (n < matrix[0].length - 1 && matrix[m][n + 1] > matrix[m][n] && !flag[m][n + 1]) {
            flag[m][n + 1] = true;
            dfs(matrix, m, n + 1, max + 1, flag);
            flag[m][n + 1] = false;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {4, 3}};
        int solve = new SolveSolve().solve(matrix);
        System.out.println(solve);
    }

}
