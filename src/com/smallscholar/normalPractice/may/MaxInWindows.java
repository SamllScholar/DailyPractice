package com.smallscholar.normalPractice.may;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 21:14
 * @describe 滑动窗口的最大值: 可以作为模板题
 * 在deque中获取元素,删除元素最好使用自己的api, getxxx, removexxx,而不是使用单纯的队列的api或者是栈的api非常容易错
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        // 需要进行窗口大小的判断, 如果窗口的大小为0, 那么直接返回空就可以了
        if (size == 0) {
            return res;
        }

        for (int i = 0; i < num.length; i++) {
            while (deque.size() > 0 && num[i] >= num[deque.getLast()]) {
                deque.removeLast();
            }
            deque.add(i);

            while (i - deque.getFirst() >= size) {
                deque.removeFirst();
            }

            if (i + 1 >= size){
                res.add(num[deque.getFirst()]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> integers = new MaxInWindows().maxInWindows(num, 3);
    }

}
