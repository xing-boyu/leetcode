package com.leetcode.dynamicprogram;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 解题思路：动态规划方程 如果num[i]>num[j] -> l[i] = max(l[j]+1,j=0...i-1) 否则l[i] = 1
 */
public class S300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] l = new int[nums.length];
        l[0] = 1;
        int max = l[0];
        for(int i=1; i<nums.length; ++i) {
            l[i] = 1;
            for(int j=0; j<i; ++j) {
                if(nums[j] < nums[i] && l[i] < l[j] + 1) {
                    l[i] = l[j] + 1;
                }
            }
            if(max < l[i]) {
                max = l[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new S300().lengthOfLIS(nums));
    }

}
