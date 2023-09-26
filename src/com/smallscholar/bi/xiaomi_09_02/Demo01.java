package com.smallscholar.bi.xiaomi_09_02;

import java.util.Scanner;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/9/2 16:28
 * @describe ...
 */
public class Demo01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        String in = sc.next();
        String[] split = in.split(",");
        long[] freq = new long[split.length];
        double[] loss = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            freq[i] = Long.parseLong(split[i].split(":")[0]);
            loss[i] = Double.parseDouble(split[i].split(":")[1]);
        }

        for (int i = 0; i < freq.length; i++) {
            if (i == 0) {
                if (target <= freq[i]) {
                    System.out.printf("%.1f%n", loss[i]);
                    break;
                }
                continue;
            }

            if (target == freq[i]) {
                System.out.printf("%.1f%n", loss[i]);
                break;
            } else if (target < freq[i]) {
                if (Math.abs(target - freq[i - 1]) == Math.abs(freq[i] - target)) {
                    double res = (loss[i - 1] + loss[i]) / 2;
                    System.out.printf("%.1f%n", res);
                    break;
                } else if (Math.abs(target - freq[i - 1]) < Math.abs(freq[i] - target)) {
                    System.out.printf("%.1f%n", loss[i - 1]);
                    break;
                } else {
                    System.out.printf("%.1f%n", loss[i]);
                    break;
                }
            }
        }

    }

}
