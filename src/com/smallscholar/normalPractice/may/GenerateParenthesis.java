package com.smallscholar.normalPractice.may;

import java.util.ArrayList;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 10:13
 */
public class GenerateParenthesis {


    ArrayList<String> res = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public ArrayList<String> generateParenthesis(int n) {
        if (n != 0) {
            dfs(temp, 0,n);
        }
        return res;
    }

    public void dfs(StringBuilder temp, int flag, int n) {
        if (temp.length() == 2 * n) {
            if (flag == 0) {
                res.add(temp.toString());
            }
            return;
        }

        if (flag < n) {
            temp.append("(");
            flag += 1;
            dfs(temp, flag, n);
            temp.deleteCharAt(temp.length() - 1);
            flag -= 1;
        }
        if (flag > 0) {
            temp.append(")");
            flag -= 1;
            dfs(temp, flag, n);
            temp.deleteCharAt(temp.length() - 1);
            flag += 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(strings.toString());
    }

}
