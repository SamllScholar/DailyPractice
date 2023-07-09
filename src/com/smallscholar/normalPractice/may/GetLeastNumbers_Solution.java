package com.smallscholar.normalPractice.may;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 21:46
 * @describe 最小的K个数
 */
public class GetLeastNumbers_Solution {

    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int j : input) {
            priorityQueue.add(j);
        }
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }

}
