package com.smallscholar.normalPractice.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 22:02
 * @describe 数据流中的中位数
 */
public class Median {

    List<Integer> list = new ArrayList<>();
    Double[] nums;

    /**
     * 这个方法在添加元素的时候直接构造出一个排序号的数组, 然后直接在下一个方法中弹出对应的数字即可
     * @param num
     */
    public void Insert(Integer num) {
        list.add(num);
        Double[] temp = new Double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = Double.valueOf(list.get(i));
        }
        Arrays.sort(temp);
        nums = temp;
    }

    public Double GetMedian() {
        if (nums.length % 2 == 0) {
            int mid = nums.length / 2;
            return (nums[mid] + nums[mid - 1]) / 2;
        } else {
            return nums[nums.length / 2];
        }
    }

}
