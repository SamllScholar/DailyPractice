package com.smallscholar.normalPractice.may;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/24 21:57
 * @describe ...
 */
public class MergeInterval {

    public ArrayList<Interval> merge (ArrayList<Interval> intervals) {
        intervals.sort((e1, e2) -> e1.start - e2.start);
        ArrayList<Interval> list = new ArrayList<>();
        for (Interval interval : intervals) {
            if (list.isEmpty()) {
                list.add(interval);
                continue;
            }
            Interval endInterval = list.get(list.size() - 1);
            if (endInterval.start <= interval.start && endInterval.end >= interval.start) {
                endInterval.end = Math.max(endInterval.end, interval.end);
                continue;
            }
            list.add(interval);
        }
        return list;
    }

}
