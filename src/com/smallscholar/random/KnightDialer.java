package com.smallscholar.random;

import java.util.HashMap;

/**
 * @author smallscholar
 * @date 2023/10/25 21:40
 * @version 1.0
 * @describe lc: 935. 骑士拨号器
 * 暴力的dfs
 */
public class KnightDialer {

    /**
     * 定义一个棋盘
     */
    int[][] chess = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
    HashMap<Integer, Integer[]> map = new HashMap<>();
    int res;

    public int knightDialer(int n) {
        map.put(0, new Integer[]{4, 6});
        map.put(1, new Integer[]{6, 8});
        map.put(2, new Integer[]{7, 9});
        map.put(3, new Integer[]{4, 8});
        map.put(4, new Integer[]{0, 3, 9});
        map.put(6, new Integer[]{0, 1, 7});
        map.put(7, new Integer[]{2, 6});
        map.put(8, new Integer[]{1, 3});
        map.put(9, new Integer[]{9, 4});

        for (int[] nums : chess) {
            for (int num : nums) {
                if (num != -1 && num != 5) {
                    bfs(map, chess, num, 1, n);
                }
            }
        }

        return res;
    }

    public void bfs(HashMap map, int[][] chess, int start, int count, int n) {
        if (count == n) {
            res = (res + 1) % (10 ^ 9 + 7);
            return;
        }
        if (start == -1) {
            return;
        }

        Integer[] nums = (Integer[]) map.get(start);
        for (Integer num : nums) {
            bfs(map, chess, num, count + 1, n);
        }

    }

    public static void main(String[] args) {
        int n = 3131;
        int i = new KnightDialer().knightDialer(n);
        System.out.println(i);
    }

}
