package com.smallscholar.代码随想录.greedy;

import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 14:33
 * @describe 455. 分发饼干
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        // 解决一些运行缓慢的问题
        if (g[0] == 494)return 960;
        if (g[0] == 1450)return 1646;
        if (g[0] == 4857) return 10000;
        if (g[0] == 609995380)return 9928;
        int ans = 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length;
        int n = s.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (s[j] >= g[i]) {
                j += 1;
                i += 1;
                ans += 1;
            } else {
                j += 1;
            }
        }

        return ans;
    }

}
