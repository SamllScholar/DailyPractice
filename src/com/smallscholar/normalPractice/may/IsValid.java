package com.smallscholar.normalPractice.may;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 21:06
 * @describe 有效括号序列
 */
public class IsValid {

    public boolean isValid (String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (charArray[i] == '(') {
                stack.push(')');
            } else if (charArray[i] == '{') {
                stack.push('}');
            } else if (charArray[i] == '[') {
                stack.push(']');
            } else {
                if (stack.size() > 0 && stack.peek() == charArray[i]) {
                    stack.poll();
                } else {
                    return false;
                }
            }

        }

        return stack.size() == 0;

    }

}
