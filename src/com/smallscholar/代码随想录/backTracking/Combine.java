package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/10 8:47
 * @describe 77. 组合
 */
public class Combine {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, 1, k, new ArrayList<>());
        return ans;
    }

    public void backTracking(int n, int start, int k, List<Integer> temp) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (n - start + 1 < k - temp.size()) {
            return;
        }
        /**
         * 如果使用for循环的代码该怎么写
         * 如果是for循环的话不需要写空回溯, 因为当前的循环就存在着空回溯
         * for (int i = start; i <= n; i++) {
         *      temp.add(start);
         *      // 使用当前的元素
         *      backTracking(n, start + 1, k, temp);
         *      // 回溯
         *      temp.remove(temp.size() - 1);
         *}
         */

        temp.add(start);
        // 使用当前的元素
        backTracking(n, start + 1, k, temp);
        // 回溯
        temp.remove(temp.size() - 1);
        // 不使用当前的
        backTracking(n, start + 1, k, temp);

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combine = new Combine().combine(n, k);
        System.out.println(combine);
    }

}
