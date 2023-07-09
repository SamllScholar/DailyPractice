package com.smallscholar.代码随想录.stackAndQueue;

import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:42
 * @describe 20. 有效的括号
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '{') {
                stack.push('}');
            } else if (ch == '[') {
                stack.push(']');
            } else if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }

}
