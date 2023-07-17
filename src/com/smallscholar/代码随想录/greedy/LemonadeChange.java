package com.smallscholar.代码随想录.greedy;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/17 9:07
 * @describe 860. 柠檬水找零
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0]++;
            } else if (bills[i] == 10) {
                if (money[0] >= 1){
                    --money[0];
                    ++money[1];
                } else {
                    return false;
                }
            } else {
                if (money[0] >= 1 && money[1] >= 1) {
                    --money[0];
                    --money[1];
                    ++money[2];
                } else if (money[0] >= 3) {
                    money[0] -= 3;
                    ++money[2];
                } else {
                    return false;
                }
            }

        }

        return true;
    }

}
