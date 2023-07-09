package com.smallscholar.代码随想录.stackAndQueue;

import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:50
 * @describe 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.empty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        while (!stack.empty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }

}
