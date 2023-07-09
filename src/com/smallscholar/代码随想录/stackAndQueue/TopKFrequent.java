package com.smallscholar.代码随想录.stackAndQueue;

import java.util.*;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 1:27
 * @describe 347. 前 K 个高频元素
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] ans = new int[k];
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        }

        for (Integer key : hashMap.keySet()) {
            int[] values = new int[] {key, hashMap.get(key)};
            priorityQueue.add(values);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.poll()[0];
        }

        return ans;
    }

}
