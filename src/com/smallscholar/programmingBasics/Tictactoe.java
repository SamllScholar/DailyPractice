package com.smallscholar.programmingBasics;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 14:51
 * @describe 编程基础第十六题: 1275. 找出井字棋的获胜者
 */
public class Tictactoe {

    public String tictactoe(int[][] moves) {
        // a代表先手方下的棋, b代表后手方下的棋, len代表总共下了多少次
        int a = 0, b = 0, len = moves.length;
        // 所有的赢得情况只有这么多: 三种竖着的情况, 三种横着的情况, 两种对角线
        int[] ac = {7, 56, 448, 73, 146, 292, 273, 84};
        for(int i = 0; i < len; i ++){
            // 如果i是后手方, 就把位运算的结果添加到b中
            if((i & 1) == 1){
                // record the step result
                b ^= 1 << (3 * moves[i][0] + moves[i][1]);
            }// 如果i是先手方, 就把位运算的结果添加到a中
            else {
                a ^= 1 << (3 * moves[i][0] + moves[i][1]);
            }
        }
        for(int i : ac){
            // 循环遍历赢的各种情况看看是A赢了还是B赢了
            if((a & i) == i){
                return "A";
            }
            if((b & i) == i){
                return "B";
            }
        }
        // 如果a,b都没赢, 判断一下是否下了9手, 如果是就是Draw, 如果不是就是Pending
        return len == 9 ? "Draw" : "Pending";
    }

}
