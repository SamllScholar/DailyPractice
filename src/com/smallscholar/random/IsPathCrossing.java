package com.smallscholar.random;

import java.util.HashSet;

/**
 * @author smallscholar
 * @date 2023/10/26 22:41
 * @version 1.0
 * @describe 1496. 判断路径是否相交
 */
public class IsPathCrossing {

    public boolean isPathCrossing(String path) {
        int n = path.length();
        int x = 0;
        int y = 0;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < n; i++) {
            if (path.charAt(i) == 'N'){
                y++;
            } else if (path.charAt(i) == 'S') {
                y--;
            } else if (path.charAt(i) == 'W') {
                x--;
            } else {
                x++;
            }
            // 这里的x * 1000是因为如果x的乘积如果太小的话可能会因为y的值太大出现一样的结果导致应该返回false的情况会返回true
            int temp = x * 1000 + y;
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
        }

        return false;
    }

}
