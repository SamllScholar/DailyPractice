package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 14:38
 * @describe 编程基础第十五题: 657. 机器人能否返回原点
 */
public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int up = 0;
        int left = 0;

        int n = moves.length();
        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'U') {
                up += 1;
            } else if (moves.charAt(i) == 'D') {
                up -= 1;
            } else if (moves.charAt(i) == 'L') {
                left += 1;
            } else {
                left -= 1;
            }
        }

        return up == 0 && left == 0;
    }

}
