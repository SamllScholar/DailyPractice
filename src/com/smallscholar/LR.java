package com.smallscholar;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/20 22:19
 * @describe 利用规范规约的原理, 针对一个简单的LR(0)文法,构造器对应的分析表, 并利用该表实现LR(0)分析器,并给出测试实例
 */
public class LR {

    private static String Sub = null;          //输入串的待处理部分
    private static boolean acc = false;        // 是否已处理完输入串
    private static boolean bResult = false;    // 是否出错
    // 转移
    private static int[][] Goto = new int[][]{{1, 2, 3}, {0, 0, 0}, {0, 0, 0},
            {0, 0, 0}, {8, 2, 3}, {0, 0, 0},
            {0, 9, 3}, {0, 0, 10}, {0, 0, 0},
            {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    // 输入要分析的字符串
    private String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入以#结尾的字符串：");
        String s = scanner.nextLine();
        scanner.close();
        return s;
    }

    public static void tran(int state, char nonterminal, Stack<String> stack) {
        int i = -1;
        if (nonterminal == 'E')
            i = 0;
        if (nonterminal == 'T')
            i = 1;
        if (nonterminal == 'F')
            i = 2;
        stack.push(nonterminal + "");
        stack.push(Goto[state][i] + "");

    }

    private void drive(String token) {
        Stack<String> anStack = new Stack<>();
        Sub = token;
        anStack.push(String.valueOf(0));
        while (!bResult && !acc) {
            switch (anStack.peek().charAt(0)) {
                case '0':
                    System.out.printf("%-52s%-50s%-50s\n", " 栈", " 输入", "动作");
                    System.out.printf("%-30s%-30s", anStack.toString(), token);
                    if (Sub.substring(0, 2).equals("id")) {
                        anStack.push("id");
                        anStack.push("" + 5);
                        Sub = Sub.substring(2, Sub.length());
                        token = token.substring(2);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals("(")) {
                        anStack.push("(");
                        anStack.push("" + 4);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case '1':
                    if ("1".equals(anStack.peek())) {
                        if (Sub.substring(0, 1).equals("+")) {
                            anStack.push("+");
                            anStack.push("" + 6);
                            Sub = Sub.substring(1, Sub.length());
                            token = token.substring(1);
                            System.out.println("移进");
                            System.out.printf("%-30s%-30s", anStack.toString(), token);
                        } else if (Sub.substring(0, 1).equals("#")) {
                            acc = true;
                            System.out.println("接受");
                            //System.out.printf("%-30s%-30s",anStack.toString(),token);
                        } else {
                            System.out.println("error");
                        }
                        break;
                    } else if (anStack.peek().charAt(1) == '0') {
                        if (Sub.substring(0, 1).equals("+") || Sub.substring(0, 1).equals(")")
                                || Sub.substring(0, 1).equals("#") || Sub.substring(0, 1).equals("*")) {
                            for (int i = 0; i < 6; i++)
                                anStack.pop();
                            tran((int) anStack.peek().charAt(0) - (int) '0', 'T', anStack);
                            System.out.println("按T->T*F归约");
                            System.out.printf("%-30s%-30s", anStack.toString(), token);
                            break;
                        } else {
                            for (int i = 0; i <= 6; i++)
                                anStack.pop();
                            tran((int) anStack.peek().charAt(0) - (int) '0', 'F', anStack);
                            System.out.println("按F->(E)归约");
                            System.out.printf("%-30s%-30s", anStack.toString(), token);
                        }
                        break;
                    }
                case '2':
                    if (Sub.substring(0, 1).equals("*")) {
                        anStack.push("*");
                        anStack.push("" + 7);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals("+") || Sub.substring(0, 1).equals(")")
                            || Sub.substring(0, 1).equals("#")) {
                        anStack.pop();
                        anStack.pop();
                        tran((int) anStack.peek().charAt(0) - (int) '0', 'E', anStack);
                        System.out.println("按E->T归约");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case '3':
                    if (Sub.substring(0, 1).equals("+") || Sub.substring(0, 1).equals("*")
                            || Sub.substring(0, 1).equals(")") || Sub.substring(0, 1).equals("#")) {
                        anStack.pop();
                        anStack.pop();
                        tran((int) anStack.peek().charAt(0) - (int) '0', 'T', anStack);
                        System.out.println("按T->F归约");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                        break;
                    }
                case '4':
                    if (Sub.substring(0, 2).equals("id")) {
                        anStack.push("id");
                        anStack.push("" + 5);
                        Sub = Sub.substring(2, Sub.length());
                        token = token.substring(2);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals("(")) {
                        anStack.push("(");
                        anStack.push("" + 4);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else
                        System.out.println("error");
                    break;
                case '5':
                    if (Sub.substring(0, 1).equals("+") || Sub.substring(0, 1).equals("*")
                            || Sub.substring(0, 1).equals(")") || Sub.substring(0, 1).equals("#")) {
                        anStack.pop();
                        anStack.pop();
                        tran((int) anStack.peek().charAt(0) - (int) '0', 'F', anStack);
                        System.out.println("按F->id归约");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    }
                    break;
                case '6':
                    if (Sub.substring(0, 2).equals("id")) {
                        anStack.push("id");
                        anStack.push("" + 5);
                        Sub = Sub.substring(2, Sub.length());
                        token = token.substring(2);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals("(")) {
                        anStack.push("(");
                        anStack.push("" + 4);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else
                        System.out.println("error");
                    break;
                case '7':
                    if (Sub.substring(0, 2).equals("id")) {
                        anStack.push("id");
                        anStack.push("" + 5);
                        Sub = Sub.substring(2, Sub.length());
                        token = token.substring(2);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals("(")) {
                        anStack.push("(");
                        anStack.push("" + 4);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else
                        System.out.println("error");
                    break;
                case '8':
                    if (Sub.substring(0, 1).equals("+")) {
                        anStack.push("+");
                        anStack.push("" + 6);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals(")")) {
                        anStack.push(")");
                        anStack.push("" + 11);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else
                        System.out.println("error");
                    break;
                case '9':
                    if (Sub.substring(0, 1).equals("*")) {
                        anStack.push("*");
                        anStack.push("" + 7);
                        Sub = Sub.substring(1, Sub.length());
                        token = token.substring(1);
                        System.out.println("移进");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    } else if (Sub.substring(0, 1).equals("+") || Sub.substring(0, 1).equals(")") || Sub.substring(0, 1).equals("#")) {
                        for (int i = 0; i <= 5; i++)
                            anStack.pop();
                        tran((int) anStack.peek().charAt(0) - (int) '0', 'E', anStack);
                        System.out.println("按E->E+T归约");
                        System.out.printf("%-30s%-30s", anStack.toString(), token);
                    }
                    break;
            }

        }
        if (acc)
            System.out.println("匹配成功");
    }

    public static void main(String[] args) {
        LR p = new LR();
        String token = p.input();
        p.drive(token);
    }
}

