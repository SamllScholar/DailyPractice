package com.smallscholar.random;

import java.util.*;

/**
 * @author smallscholar
 * @date 2023/10/26 17:02
 * @version 1.0
 * @describe lc: 1348. 推文计数 我的时间复杂度超时了, 我的是n的时间复杂度, 需要的是logn的时间复杂度
 */
public class TweetCounts {

    HashMap<String, Integer> timeMap;
    HashMap<String, List<Integer>> nameMap;

    public TweetCounts() {
        timeMap = new HashMap<>();
        nameMap = new HashMap<>();
        timeMap.put("minute", 60);
        timeMap.put("hour", 3600);
        timeMap.put("day", 86400);
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> list = nameMap.getOrDefault(tweetName, new ArrayList<>());
        list.add(time);
        nameMap.put(tweetName, list);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int time = timeMap.get(freq);
        List<Integer> list = nameMap.get(tweetName);
        if (list.isEmpty()) {
            return list;
        }
        int n = endTime / time + 1;
        int[] counts = new int[n];

        for (Integer num : list) {
            if (num >= startTime && num <= endTime) {
                int temp = num / time;
                if (temp < n) {
                    counts[temp]++;
                }
            }
        }

        int x = (endTime - startTime) / time + 1;
        List<Integer> res = new ArrayList<>();
        for (int i = n - x; i < n; i++) {
            res.add(counts[i]);
        }

        return res;
    }

}
