package com.leetcode.bytedance.array;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1035/
 *
 * 题目：最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 *
 *
 *
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 *
 * 注意：数组长度不会超过10000。
 *
 * 解题思路：水题，直接遍历一遍数组即可以找对最长且连续的升序子序列
 *
 */
public class 最长连续递增序列 {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }

        int max = 0;

        int length = 1;
        for(int i=1; i<nums.length; ++i) {
            if(nums[i] > nums[i-1]) {
                ++length;
                continue;
            }

            if(max < length) {
                max = length;
            }

            length = 1;
        }

        return max > length ? max : length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2};
        System.out.println(new 最长连续递增序列().findLengthOfLCIS(nums));
    }

}