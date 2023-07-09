package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 0:06
 * @describe 入门变成第19题: 2586. 统计范围内的元音字符串数
 */
public class VowelStrings {

    public int vowelStrings(String[] words, int left, int right) {
        //标注元音字符在数组中的位置
        int[] arr = new int[26];
        arr['a'-'a']++;
        arr['e'-'a']++;
        arr['i'-'a']++;
        arr['o'-'a']++;
        arr['u'-'a']++;
        int count = 0;
        for (int i = left; i < words.length&&i<right+1; i++) {
            int length = words[i].length();
            //如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串
            if (arr[words[i].charAt(0)-'a']>0&&
                    arr[words[i].charAt(length-1)-'a']>0){
                count++;
            }
        }
        return count;
    }

}
