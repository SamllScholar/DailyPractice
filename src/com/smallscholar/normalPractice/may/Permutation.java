package com.smallscholar.normalPractice.may;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 8:59
 * 字符串的排列
 */
public class Permutation {

    ArrayList<String> res = new ArrayList<>();

    StringBuilder temp = new StringBuilder();
    public ArrayList<String> permutation(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        int n = array.length;
        boolean[] flag = new boolean[n];
        if (n > 0) {
            dfs(array, n, temp, flag);
        }

        return res;
    }

    public void  dfs(char[] array, int n, StringBuilder temp, boolean[] flag) {
        if (temp.length() == n) {
            res.add(temp.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            if (i > 0 && array[i] == array[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            temp.append(array[i]);
            dfs(array, n, temp, flag);
            flag[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "aac";
        ArrayList<String> permutation = new Permutation().permutation(str);
        System.out.println(permutation.toString());
    }
}
