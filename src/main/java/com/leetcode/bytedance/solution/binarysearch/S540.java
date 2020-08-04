package com.leetcode.bytedance.solution.binarysearch;

/**
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 */
public class S540 {

    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int index = search(nums,0, nums.length-1);
        if(index >=0 && index<=nums.length-1) {
            return nums[index];
        }
        return -1;

    }

    private int search(int[] nums, int l, int r) {
        if(r-l<0) {
            return -1;
        }

        int m = l + ((r - l) >> 1);
        if (m>0 && nums[m] != nums[m - 1] && m < nums.length-1 && nums[m] != nums[m + 1]) {
            return m;
        }

        if(m == nums.length-1 && m > 0 && nums[m] != nums[m - 1]) {
            return m;
        }

        if(m == 0 && m < nums.length-1 && nums[m] != nums[m + 1]) {
            return m;
        }

        int lr, rr;
        if(m>0 && nums[m] == nums[m - 1]) {
            lr = search(nums, l, m-2);
            rr = search(nums, m+1, r);
            return Math.max(lr, rr);
        }

        if(m < nums.length-1 && nums[m] == nums[m + 1]) {
            lr = search(nums, l, m-1);
            rr = search(nums, m+2, r);
            return Math.max(lr, rr);
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new S540().singleNonDuplicate(nums));
    }
}
