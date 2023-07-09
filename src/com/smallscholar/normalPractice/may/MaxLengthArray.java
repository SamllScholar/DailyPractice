package com.smallscholar.normalPractice.may;

import java.util.HashSet;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 14:14
 * @describe BM92 最长无重复子数组
 */
public class MaxLengthArray {

    public int maxLength(int[] arr) {
        HashSet<Integer> cur = new HashSet<>();
        int len = Integer.MIN_VALUE;

        for (int left = 0, right = 0; right < arr.length; right++) {
            // 如果set中没有当前的元素,直接添加到set中并且更新一个结果len的值
            if (!cur.contains(arr[right])) {
                cur.add(arr[right]);
                len = Math.max(len, cur.size());
                continue;
            }
            // 如果set中已经有了当前的元素把重复元素及之前的元素全部删除并更新left
            while (left < right && cur.contains(arr[right])){
                cur.remove(arr[left]);
                left += 1;
            }
            // 添加冲突的元素并且更新len
            cur.add(arr[right]);
            len = Math.max(len, cur.size());
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,3,4,8,99,3};
        int i = new MaxLengthArray().maxLength(arr);
        System.out.println(i);
    }

}
