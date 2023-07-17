package com.smallscholar.代码随想录.greedy;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 22:55
 * @describe 1005. K 次取反后最大化的数组和
 */
public class LargestSumAfterKNegations {

    /**
     * 思路: 把-100 - 100 的范围映射到0 - 200 的返回, 因为有k次翻转, 所以进行k次循环, 先翻转最小的负数(也就是反转后最大的)
     * 如果k用完了, 当前的索引还小于100 那么证明当前的负数的数量大于k, sum最后直接添加可以就行了
     * 如果k > 负数的数量, 那么会翻转正数(此时所有的负数已经翻转完成, 那么现在只剩下正数了, 只需要不断的翻转第一个正数就可以了)
     *
     * 因为这个题的数据量非常的小, 所以可以使用一个大小200的数组就可以了
     * @param A
     * @param K
     * @return
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] number = new int[201];//-100 <= A[i] <= 100,这个范围的大小是201
        for (int t : A) {
            number[t + 100]++;//将[-100,100]映射到[0,200]上
        }
        int i = 0;
        while (K > 0) {
            while (number[i] == 0)//找到A[]中最小的数字
                i++;
            number[i]--;//此数字个数-1
            number[200 - i]++;//其相反数个数+1
            if (i > 100) {//若原最小数索引>100,则新的最小数索引应为200-i.(索引即number[]数组的下标)
                i = 200 - i;
            }
            K--;
        }
        int sum = 0;
        for (int j = i; j <number.length ; j++) {//遍历number[]求和
            sum += (j-100)*number[j];//j-100是数字大小,number[j]是该数字出现次数.
        }
        return sum;
    }

}
