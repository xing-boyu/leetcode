package com.leetcode.graph;

/**
 * https://leetcode-cn.com/problems/array-nesting/
 */
public class S565 {

    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        boolean[] f = new boolean[nums.length];
        for(int i=0; i<nums.length; ++i) {
            if(f[i]) {
                continue;
            }

            int l = 0;
            int index = i;
            while (!f[index]) {
                ++l;
                f[index] = true;
                index = nums[index];
            }

            if(sum < l) {
                sum = l;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,0,3,1,6,2};
        System.out.println(new S565().arrayNesting(nums));
    }

}
