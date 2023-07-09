package com.smallscholar.normalPractice.may;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/13 23:25
 * 没有重复项数字的全排列
 */
public class Permute {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        int n = num.length;
        if (n != 0) {
            dfs(num, n);
        }
        return res;
    }

    public void  dfs(int[] num, int n) {
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        // 经典的的dfs解法, 因为需要按字典序进行排序, 所以可以使用循环遍历数组进行判断这样就可以保证有序了
        // 如果当前的解集中没有当前的元素就把当前的元素添加到当前的解集中, 并且添加完运算完成之后需要恢复现场(这一点非常的重要)
        for (int i = 0; i < n; i++) {
            if (!temp.contains(num[i])) {
                temp.add(num[i]);
                dfs(num, n);
                // 恢复现场非常的重要
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        ArrayList<ArrayList<Integer>> permute = new Permute().permute(num);
        System.out.println(permute);
    }

}
