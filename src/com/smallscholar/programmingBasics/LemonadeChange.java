package com.smallscholar.programmingBasics;

import org.omg.CORBA.OMGVMCID;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/30 22:38
 * @describe 编程基础第24题: 860. 柠檬水找零
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
