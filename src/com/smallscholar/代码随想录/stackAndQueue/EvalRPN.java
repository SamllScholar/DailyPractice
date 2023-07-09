package com.smallscholar.代码随想录.stackAndQueue;

import java.util.Objects;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/9 0:54
 * @describe 150. 逆波兰表达式求值
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (!Objects.equals(token, "+") && (!Objects.equals(token, "-")) &&
                    (!Objects.equals(token, "*")) && (!Objects.equals(token, "/"))) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if (token.equals("+")) {
                    stack.push(String.valueOf(num1 + num2));
                } else if (token.equals("-")) {
                    stack.push(String.valueOf(num1 - num2));
                } else if (token.equals("*")) {
                    stack.push(String.valueOf(num1 * num2));
                } else {
                    stack.push(String.valueOf(num1 / num2));
                }
            }
        }

        return Integer.parseInt(stack.peek());
    }

}
