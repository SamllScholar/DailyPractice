package com.smallscholar.dailyPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/25 13:24
 * @describe leetcode:1401. 圆和矩形是否有重叠 --> 求矩形和圆形是否相交
 * 思路: 其中一种简单的思路就是: 分情况进行讨论
 * 圆「贴」在矩形的四周: 这种情况可以分为圆在矩形上面贴着,圆在矩形下面贴着,圆在矩形左边贴着,圆在矩形右边贴着
 * 圆「顶」在矩形的顶点: 圆的边贴着矩形的右上角的顶点...
 * 圆和矩形不想交
 * 圆心在矩形的内部
 * 数学的思路:
 * 利用点到直线的距离来求解
 * 我们可以找出来一个点, 这个点到圆的距离是最小的,如果这个点到圆心的距离小于圆的半径, 那么就证明当前的矩形和当前的圆是相交的
 * Xmin =  min(x1 - xCenter, x2 - xCenter);
 * Ymin = min(y1 - yCenter, y2 - yCenter);
 * dist = asr(Xmin.pow + Ymin.pow);
 * 最后直接返回dis < r就可以了, 如果相等的话,那么这个矩形一个和这个圆有一个地方是相交的
 */
public class CheckOverlap {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double dist = 0;
        if (xCenter < x1 || xCenter > x2) {
            dist += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(x2 - xCenter, 2));
        }
        if (yCenter < y1 || yCenter > y2) {
            dist += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(y2 - yCenter, 2));
        }

        return dist <= radius * radius;
    }

}
