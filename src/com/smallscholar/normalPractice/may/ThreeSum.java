package com.smallscholar.normalPractice.may;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 23:51
 * @describe ...
 */
public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;

        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                continue;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right){
                if (num[i] + num[left] + num[right] == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(num[i]);
                    temp.add(num[left]);
                    temp.add(num[right]);
                    res.add(temp);
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) {
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {
                        right--;
                    }
                } else if (num[i] + num[left] + num[right] > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] num = {0,0,0};
        ArrayList<ArrayList<Integer>> arrayLists = new ThreeSum().threeSum(num);
        System.out.println(arrayLists.toString());
    }

}
