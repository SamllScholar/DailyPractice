package com.smallscholar.normalPractice.may;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 22:56
 * @describe 数组中只出现一次的两个数字
 */
public class FindNumsAppearOnce {

    public int[] findNumsAppearOnce (int[] array) {
        int xor = 0;
        for (int num : array) {
            xor ^= num;
        }
        // 保存number
        int number = xor;
        // 取出xor的第一个非0比特位, 因为xor一定是那两个数异或的结果, 如果两个数异或, 那么他们相同的数位一定为0, 不同的数位
        // 一定为1, 所以第一个不为0的数位在这两个数字中一定不同我们可以根据这个进行区分
        int temp = (xor & ~(xor - 1));
        // 通过这个数位可以筛选出两个数字中的一个
        for (int num : array) {
            if ((num & temp) != 0) {
                xor ^= xor;
            }
        }
        // 然后在根据第一次求出来的异或的结果求出两个一数
        temp = number ^ xor;
        return new int[]{Math.min(temp, xor), Math.max(temp, xor)};
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 1, 6};
        int[] numsAppearOnce = new FindNumsAppearOnce().findNumsAppearOnce(array);
        System.out.println(numsAppearOnce);
    }

}
