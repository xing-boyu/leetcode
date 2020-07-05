package com.leetcode.bytedance.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 *
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 解题思路：set中存储nums中的值，在遍历到nums的值时向左、向右搜索找到最长的连续序列，同时统计连续序列长度
 *
 * 后面看了别人的解题思路可以先判断下有向左一步元素存不存在set，如果不存在直接往右搜索就能得到结果。
 */
public class SolutionSix {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 0;

        Set<Integer> f = new HashSet<Integer>();
        for(int i=0; i<nums.length; ++i) {
            f.add(nums[i]);
            int length = 1;

            // 向左搜索
            int l = nums[i]-1;
            while (f.contains(l)) {
                ++length;
                --l;
            }

            // 向右搜索
            int r = nums[i]+1;
            while (f.contains(r)) {
                ++length;
                ++r;
            }
            if(maxLength < length) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new SolutionSix().longestConsecutive(nums));
    }

}