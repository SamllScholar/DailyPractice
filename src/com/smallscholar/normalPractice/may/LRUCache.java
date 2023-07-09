package com.smallscholar.normalPractice.may;

import jdk.nashorn.internal.ir.IfNode;

import java.lang.annotation.Target;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/26 12:45
 * @describe ...
 */
public class LRUCache {

    public ArrayList<String> LRUCache(ArrayList<String> operators,
                                      ArrayList<ArrayList<Integer>> param, int capacity) {
        int n = operators.size();
        HashMap<String, ArrayList<Integer>> temp = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < n; i++) {
            temp.put(operators.get(i), param.get(i));
        }

        for (String operator : operators) {
            add(cache);
            ArrayList<Integer> value = temp.get(operator);
            if (operator.equals("set")) {
                set(hashMap, cache, value.get(0), value.get(1), capacity);
                res.add("null");
            } else {
                if (get(cache, value.get(0), capacity) != -1) {
                    res.add(hashMap.get(value.get(0)).toString());
                } else {
                    res.add("-1");
                }
            }
        }

        return res;

    }

    public void set(HashMap<Integer, Integer> hashMap,HashMap<Integer, Integer> cache, int key, int value, int capacity) {
        cache.put(key, 1);
        hashMap.put(key, value);
        remove(cache, capacity);
    }

    public int get(HashMap<Integer, Integer> cache, int target, int capacity) {
        if (cache.containsKey(target)) {
            cache.put(target, 1);
            remove(cache, capacity);
            return target;
        } else {
            return -1;
        }

    }

    public void add(HashMap<Integer, Integer> cache) {
        cache.replaceAll((k, v) -> cache.get(k) + 1);
    }

    public void remove(HashMap<Integer, Integer> cache, int capacity) {
        int temp = -1;
        for (Integer key : cache.keySet()) {
            int value = cache.get(key);
            if (value > capacity) {
                temp = key;
                break;
            }
        }
        if (temp != -1) {
            cache.remove(temp);
        }
    }

}
