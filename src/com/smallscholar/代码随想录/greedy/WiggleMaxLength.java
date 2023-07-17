package com.smallscholar.代码随想录.greedy;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/7/12 14:41
 * @describe 376. 摆动序列
 */
public class WiggleMaxLength {

    public int wiggleMaxLengthUp(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        // 找到前一个上升或下降的子序列
        int prevdiff = nums[1] - nums[0];
        // 如果初始的两个元素相同, 那么表示没有递增或递减的子序列, 可以长度就为1, 否则为2
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            // 如果之前的递增序列和现在的不同, 那么就是可用解, 结果加一, 更新prevDiff
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int maxLen = 1;

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1] && !flag) {
                    len += 1;
                    flag = true;
                } else if (nums[j] < nums[j - 1] && flag) {
                    flag = false;
                    len += 1;
                }
                maxLen = Math.max(len, maxLen);
            }
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1] && flag) {
                    len += 1;
                    flag = false;
                } else if (nums[j] < nums[j - 1] && !flag) {
                    flag = true;
                    len += 1;
                }
                maxLen = Math.max(len, maxLen);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {102,101,20,91,156,78,75,142,69,81,46,142,113,163,190,178,13,36,134,54};

        int i = new WiggleMaxLength().wiggleMaxLength(nums);
        System.out.println(i);
    }

}
