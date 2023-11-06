package com.smallscholar.lcr;

import jdk.internal.org.objectweb.asm.commons.RemappingAnnotationAdapter;

import java.net.Inet4Address;
import java.util.*;

/**
 * @author smallscholar
 * @date 2023/11/5 23:11
 * @version 1.0
 * @describe LCR 030. O(1) 时间插入、删除和获取随机元素
 */
public class RandomizedSet {

    List<Integer> nums;
    HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        int size = nums.size();
        nums.add(val);
        map.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Integer lastPar = nums.get(nums.size() - 1);
        Integer curPar = map.get(val);
        nums.set(curPar,lastPar);
        nums.remove(nums.size() - 1);
        map.put(lastPar, curPar);
        map.remove(val);
        return true;
    }


    public int getRandom() {
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }

}
