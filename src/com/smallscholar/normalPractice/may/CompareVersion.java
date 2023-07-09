package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/18 16:19
 * @describe 比较版本号
 */
public class CompareVersion {

    public int compare (String version1, String version2) {
        String[] str1 = version1.split("\\.");
        int length1 = str1.length - 1;
        String[] str2 = version2.split("\\.");
        int length2 = str2.length - 1;
        int length = Math.max(length1, length2);

        // 拿到没部分的版本号, 如果当前位置没有版本号,默认是0
        for (int i = 0; i <= length; i++) {
            int num1 = length1 < i ? 0 : Integer.parseInt(str1[i]);
            int num2 = length2 < i ? 0 : Integer.parseInt(str2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}
