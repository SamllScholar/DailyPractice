package com.smallscholar.代码随想录.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/10 9:25
 * @describe 216. 组合总和 III
 */
public class CombinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (getSum(k) < n) {
            return ans;
        }
        backTracking(n, k, 1);
        return ans;
    }

    /**
     * 这个题有一个很怪的地方, 这个题的界限是9而不是n
     * @param n
     * @param k
     * @param start
     */
    public void backTracking(int n, int k, int start) {
        if (temp.size() == k && sum == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if ((9 - start + 1 < k - temp.size()) || (sum >= n && k - temp.size() > 0) || start > 9) {
            return;
        }

        sum += start;
        temp.add(start);
        backTracking(n, k, start + 1);
        sum -= start;
        temp.remove(temp.size() - 1);
        backTracking(n, k, start + 1);
    }

    public int getSum(int k) {
        int temp = 0;
        for (int i = 9; i >= 9 - k; i--) {
            temp += i;
        }

        return temp;
    }

    public static void main(String[] args) {
        int k = 9;
        int n = 45;
        List<List<Integer>> lists = new CombinationSum3().combinationSum3(k, n);
        System.out.println(lists);
    }


}
