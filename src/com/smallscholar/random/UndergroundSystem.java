package com.smallscholar.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author smallscholar
 * @date 2023/10/22 22:38
 * @version 1.0
 * @describe lc: 1396. 设计地铁系统
 * 这里的代码有一个bug, 因为使用hash表来存储对应id对应的进站时间与出站时间,当有一个人多次从一个站进栈并且从另外的一个站出站
 * 的时候只会统计一次, 实际需要多次的计算, 这里可以把inTime与outTime对应的hash表的value换成list, 因为list是有序的,即使
 * 无序的也没有关系, 因为需要的结果肯定是outTime的和 - inTime的和, 这样就可以了, 不过要注意的是, 在求和的时候要以同一id对应的
 * list的最小的长度求和这样就可以了(因为同一个人可能在同一个地方进站但是不一定在同一个地方出站)
 */
public class UndergroundSystem {

    HashMap<Integer, Integer> inTime;
    HashMap<Integer, Integer> outTime;
    HashMap<String, List<Integer>> startStationMap;
    HashMap<String, List<Integer>> endStationMap;

    /**
     * 构造函数, 为map初始化
     */
    public UndergroundSystem() {
        inTime = new HashMap<>();
        outTime = new HashMap<>();
        startStationMap = new HashMap<>();
        endStationMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        List<Integer> list = startStationMap.getOrDefault(stationName, new ArrayList<>());
        inTime.put(id, t);
        list.add(id);
        startStationMap.put(stationName, list);
    }

    public void checkOut(int id, String stationName, int t) {
        List<Integer> list = endStationMap.getOrDefault(stationName, new ArrayList<>());
        outTime.put(id, t);
        list.add(id);
        endStationMap.put(stationName, list);
    }

    public double getAverageTime(String startStation, String endStation) {
        int count = 0;
        int sum = 0;
        List<Integer> startList = startStationMap.get(startStation);
        List<Integer> endList = endStationMap.get(endStation);

        for (Integer id : startList) {
            if (endList.contains(id)) {
                count += 1;
                int startTime = inTime.get(id);
                int endTime = outTime.get(id);
                sum = sum + endTime - startTime;
            }
        }

        return (double) sum / count;

    }

}
