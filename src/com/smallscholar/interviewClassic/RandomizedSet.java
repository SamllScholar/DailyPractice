package com.smallscholar.interviewClassic;

import java.util.*;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/2 23:56
 * @describe 面试经典第十二题: 380. O(1) 时间插入、删除和获取随机元素
 * 使用一个集合和一个hashmap共同解决,
 */
class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        // 获取当前元素所在的位置
        int index = indices.get(val);
        // 获取集合中的最后一个元素
        int last = nums.get(nums.size() - 1);
        // 把最后一个元素的值赋值给当前的位置
        nums.set(index, last);
        // 更新最后一个元素的位置为当前元素的位置
        indices.put(last, index);
        // 在集合中删除最后一个元素和map中删除当前的元素
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
