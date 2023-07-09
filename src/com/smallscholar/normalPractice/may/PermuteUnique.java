package com.smallscholar.normalPractice.may;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/13 23:53
 * 有重复项数字的全排列
 */
public class PermuteUnique {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        int n = num.length;
        boolean[] flag = new boolean[n];
        if (n != 0) {
            // 对数组进行排序, 使得进行深度遍历的时候,形成的结果可以按照字典序升序进行输出
            Arrays.sort(num);
            dfs(num, flag, n);
        }
        return res;
    }

    /**
     * 这个有重复相较于没有重复的难点在于如何判断重复的元素有没有全部使用完毕, 如何判断有没有多的使用
     * @param num
     * @param flag
     * @param n
     */
    public void  dfs(int[] num, boolean[] flag, int n) {
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 如果当前的元素被使用过了, 直接进行跳过就可以了,相当于前面的contains判断
            if (flag[i]){
                continue;
            }
            // 使用一个数组来判断当前的元素有没有被使用, 并且可以进行结果的去重(1, 1, 2)如果结果不去重将会有两个
            // 我们可以只让第一个相同的元素产生结果集进行回溯, 如果是接下来的重复元素直接跳过就可以了, 下面的if就是去除重复结果集的
            if (i > 0 && num[i] == num[i - 1] && !flag[i - 1]) {
                continue;
            }
            // 把当前的元素标记为已经使用把当前的元素添加到结果集
            flag[i] = true;
            temp.add(num[i]);
            dfs(num, flag, n);
            // 进度遍历完成后,把当前的数据进行回溯
            flag[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 1, 2};
        ArrayList<ArrayList<Integer>> arrayLists = new PermuteUnique().permuteUnique(num);
        System.out.println(arrayLists.toString());
    }

}
