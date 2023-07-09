package com.smallscholar.代码随想录.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/8 16:26
 * @describe 349. 两个数组的交集
 * 我下面使用的是双集合的方案, 还可以使用排序加双指针的方法
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i) && !list.contains(i)) {
                list.add(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}
