package com.smallscholar.interviewClassic;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/3 17:03
 * @describe 面试经典第二十四题: 6. N 字形变换
 */
public class Convert {

    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r >= n) {
            return s;
        }
        // 周期
        int t = r * 2 - 2;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < r; i++) { // 枚举行
            for (int j = 0; j < n - i; j += t) { // 枚举每个周期的起始索引
                ans.append(s.charAt(i + j)); // 当前周期的第一个字符
                if (i > 0 && i < r - 1 && j + t - i < n)
                    ans.append(s.charAt(j + t - i)); // 枚举当前周期的第二个字符
            }
        }
        return ans.toString();
    }

}
