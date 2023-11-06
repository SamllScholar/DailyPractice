package com.smallscholar.lcr;

/**
 * @author smallscholar
 * @date 2023/10/27 16:18
 * @version 1.0
 * @describe LCR 005. 最大单词长度乘积
 * 如果需要多次判断两个字符串中是否有相同的字符可以使用二进制数组预处理的方法进行字符串的预处理, 把每个字符串的出现的字符保存在一个
 * int类型的数字中, 那么每一位就代表一个字母, 只需要两个数字&看结果是否为0就可以判断两个字符串是否有相同的字符了
 */
public class MaxProduct {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] chars = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                // 这里一要使用或运算, 如果使用+的话那么如果有多个相同的字符会导致结果错误
                chars[i] |= 1 << (word.charAt(j) - 'a');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((chars[i] & chars[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }

}
