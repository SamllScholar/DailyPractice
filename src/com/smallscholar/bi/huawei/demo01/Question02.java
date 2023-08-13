package com.smallscholar.bi.huawei.demo01;

import java.util.*;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/8/13 20:47
 * @describe 2、海量日志抑制
 *  https://ujimatsu-chiya.github.io/EXAM/Huawei-20230524/#%E6%B5%B7%E9%87%8F%E6%97%A5%E5%BF%97%E6%8A%91%E5%88%B6
 */
public class Question02 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> logs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            logs.add(sc.nextLine());
        }
        //获得输出结果
        List<String> result = suppressLogs(logs);

        for (String log : result) {
            System.out.println(log);
        }
    }

    public static List<String> suppressLogs(List<String> logs) {
        //存储输出结果
        List<String> result = new ArrayList<>();
        // 存储相同日志的最后一个时间戳
        Map<String, Integer> sameLogCount = new HashMap<>();
        // 存储相似日志的计数器
        Map<String, Integer> similarLogCount = new HashMap<>();
        // 存储相似日志的最后一个时间戳
        Map<String, Integer> similarLogTimestamp = new HashMap<>();

        for (String log : logs) {
            //遍历每一个输入日志条
            String[] parts = log.split(":");
            // 获得时间戳
            long timestamp = Long.parseLong(parts[0]);
            // 获得日志内容
            String content = parts[1];
            // 去除日志中的数字
            String similarContent = content.replaceAll("\\d+", "");
            boolean suppressed = false;
            // 相同日志抑制
            if (sameLogCount.containsKey(content)) {
                // 有存放一样的日志内容
                // 得到存放的日志内容的时间
                int lastTimestamp = sameLogCount.get(content);
                if (timestamp - lastTimestamp < 10) {
                    // 在10ms内，抑制
                    suppressed = true;
                } else {
                    // 超时了没事，重复无所谓
                    sameLogCount.put(content, (int) timestamp);// 这里覆盖了，内容一样但是时间更新了
                }
            } else {
                // 这条日志内容没存过，存进去
                sameLogCount.put(content, (int) timestamp);
            }
            if (!suppressed && similarLogCount.containsKey(similarContent)) {
                // 之前存有相似日志
                // 取得相似出现次数
                int count = similarLogCount.get(similarContent);
                // 取得存放相似时间
                int lastTimestamp = similarLogTimestamp.get(similarContent);
                if (timestamp - lastTimestamp < 100) {
                    if (count >= 9) {
                        suppressed = true;
                    } else {
                        similarLogCount.put(similarContent, count + 1);
                    }
                } else {
                    //已经超时了，前面的数据计数作废，重新计数和记录时间
                    similarLogCount.put(similarContent, 1);
                    similarLogTimestamp.put(similarContent, (int) timestamp);
                }
            } else if (!(similarLogCount.containsKey(similarContent))) {
                // 没有相似，即只出现一次，存放次数
                similarLogCount.put(similarContent, 1);
                // 没有相似，存放时间
                similarLogTimestamp.put(similarContent, (int) timestamp);
            }
            if (!suppressed) {
                //不受抑制，加入result
                result.add(log);
            }
        }
        return result;
    }
}
