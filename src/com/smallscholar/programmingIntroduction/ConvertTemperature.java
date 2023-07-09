package com.smallscholar.programmingIntroduction;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/6/29 21:30
 * @describe 编程入门第二题: 2469. 温度转换
 */
public class ConvertTemperature {

    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = celsius * 1.80 + 32.00;
        return res;
    }

}
