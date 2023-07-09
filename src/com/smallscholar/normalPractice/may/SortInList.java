package com.smallscholar.normalPractice.may;

import java.util.ArrayList;
import java.util.List;

/**
 * @author smallscholar
 * @version 1.0
 * @date 2023/5/14 18:19
 * @describe ...
 */
public class SortInList {

    public ListNode sortInList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        quickSort(nums, 0, nums.length - 1);
        ListNode res = new ListNode(-1);
        ListNode cur2 = res;
        for (int j = 0; j < nums.length; j++) {
            cur2.next = new ListNode(nums[j]);
            cur2 = cur2.next;
        }
        return res.next;

    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int part = partition(nums, l, r);
            quickSort(nums, l, part - 1);
            quickSort(nums, part + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int bench = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= bench) {
                r--;
            }
            if (l < r) {
                nums[l] = nums[r];
            }
            while (l < r && nums[l] <= bench) {
                l++;
            }
            if (l < r) {
                nums[r] = nums[l];
            }
        }
        nums[l] = bench;
        return l;
    }

}
