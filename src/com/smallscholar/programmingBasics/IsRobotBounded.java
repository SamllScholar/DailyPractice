package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 15:17
 * @describe 编程基础第17题: 1041. 困于环中的机器人
 */
public class IsRobotBounded {

    public boolean isRobotBounded(String instructions) {
        int up = 0;
        int left = 0;
        int flag = 0;

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                char ch = instructions.charAt(i);
                if (ch == 'L') {
                    flag = (flag + 3) % 4;
                } else if (ch == 'R') {
                    flag = (flag + 1) % 4;
                } else {
                    if (flag == 0) {
                        up += 1;
                    } else if (flag == 1) {
                        left -= 1;
                    } else if (flag == 2) {
                        up -= 1;
                    } else {
                        left += 1;
                    }
                }
            }
        }
        return up == 0 && left == 0;
    }

}
