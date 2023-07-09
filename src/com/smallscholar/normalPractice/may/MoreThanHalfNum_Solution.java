package com.smallscholar.normalPractice.may;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 22:44
 * @describe 数组中出现次数超过一半的数字
 * 用到的算法: 摩尔投票算法
 * 算法思路: 如果一个事物的数量大于总体数量的一半, 我们可以选取任意的事物当做候选人, 然后总体进行遍历, 如果接下来的事物
 * 和当前的事物相同的话当前事务的得分就加一, 如果不同的话当前候选事物的得分就减一, 如果当前的候选事物的得分为0, 那么就选取
 * 当前的事物为候选事物, 因为目标事务的数量大于总数量的一半, 所以即使其他的所有事物一次当候选事物最后都会为0, 最后目标事物都会变成
 * 候选事物, 我们总是可以得到目标的事物
 */
public class MoreThanHalfNum_Solution {

    public int moreThanHalfNum_Solution(int [] array) {
        int candidate = array[0];
        int vote = 1;
        for (int i = 1; i < array.length; i++) {
            if (candidate == array[i]) {
                vote += 1;
            } else {
                vote -= 1;
                if (vote == 0) {
                    candidate = array[i];
                    vote = 1;
                }
            }
        }

        return candidate;
    }

}
