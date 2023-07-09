package com.smallscholar.normalPractice.may;

import javafx.scene.layout.GridPane;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 8:36
 * 岛屿数量
 */
public class Solve {

    public int solve(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 循环遍历每一为1的岛屿
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i, j);
                    res += 1;
                }
            }
        }

        return res;
    }

    /**
     * 把和当前岛屿相连的为'1'的岛屿全部遍历一遍并且把遍历过的岛屿变成'0',这样就不会出现重复判断的问题
     * @param grid
     * @param m
     * @param n
     */
    public void dfs(char[][] grid, int m, int n) {
        // 当前的节点遍历过, 就变成0放置重复的遍历
        grid[m][n] = '0';
        if (m > 0 && grid[m - 1][n] == '1') {
            dfs(grid, m - 1, n);
        }
        if (m < grid.length - 1 && grid[m + 1][n] == '1') {
            dfs(grid, m + 1, n);
        }
        if (n > 0 && grid[m][n - 1] == '1') {
            dfs(grid, m, n - 1);
        }
        if (n < grid[0].length - 1 && grid[m][n + 1] == '1') {
            dfs(grid, m, n + 1);
        }
        return;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'0','1','0','1','1'},
                {'0','0','0','1','1'},
                {'0','0','0','0','0'},
                {'0','0','1','1','1'}};
        int solve = new Solve().solve(grid);
        System.out.println(solve);
    }

}
