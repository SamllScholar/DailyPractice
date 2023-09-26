package com.smallscholar.newStart.september;

/**
 * @author smallscholar
 * @date 2023/9/26 13:14
 * @version 1.0
 * @describe 2511. 最多可以摧毁的敌人城堡数目
 */
public class Day_02 {

    public int captureForts(int[] forts) {
        int max = 0;
        int n = forts.length;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            if (forts[i] == 1) {
                i += 1;
                while (i < n && forts[i] != -1) {
                    if (forts[i] == 0) {
                        temp += 1;
                    } else if (forts[i] == 1) {
                        temp = 0;
                    }
                    i += 1;
                }
                if (i < n && forts[i] == -1) {
                    max = Math.max(temp, max);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = 0;
            if (forts[i] == 1) {
                i -= 1;
                while (i >= 0 && forts[i] != -1) {
                    if (forts[i] == 0) {
                        temp += 1;
                    } else if (forts[i] == 1) {
                        temp = 0;
                    }
                    i -= 1;
                }

                if (i >= 0 && forts[i] == -1) {
                    max = Math.max(temp, max);
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,-1,0,0,0,0,1};
        int i = new Day_02().captureForts(nums);
        System.out.println(i);
    }

}
