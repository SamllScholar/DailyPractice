package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/10 11:32
 * @describe 131. 分割回文串
 * 动态规划加回溯法
 * 本题学到的东西: 有时候一个题并不是单纯的回溯题, 可能在回溯之前需要进行数据的处理
 */
public class Partition {

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> a = new Partition().partition("aab");
        System.out.println(a);
    }

}
