package com.smallscholar.bi.xiaomi_09_02;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/9/2 16:55
 * @describe ...
 */
public class Demo02 {

    public static class Task {
        int low;
        int need;

        public Task(int low, int need) {
            this.low = low;
            this.need = need;
        }

        public Task() {
        }

        public int getLow() {
            return low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public int getNeed() {
            return need;
        }

        public void setNeed(int need) {
            this.need = need;
        }
    }


    public static void main(String[] args) {

        int low = 0;

        PriorityQueue<Task> queue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.low == o2.low) {
                    return o1.need - o2.need;
                } else {
                    return o2.low - o1.low;
                }
            }
        });

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (!str.isEmpty()) {
            String[] s = str.split(",");
            for (String string : s) {
                Task task = new Task();
                task.setLow(Integer.parseInt(string.split(":")[1]));
                task.setNeed(Integer.parseInt(string.split(":")[0]));
                queue.add(task);
            }
            low = queue.peek().low;
            int min = low;
            while (!queue.isEmpty()) {
                Task task = queue.poll();
                if (low >= task.low) {
                    low -= task.need;
                } else {
                    min += task.low - low;
                    low = task.low;
                    low -= task.need;
                    if (min > 4800) {
                        min = -1;
                        break;
                    }
                }
            }

            System.out.println(min);
        }
    }

}
