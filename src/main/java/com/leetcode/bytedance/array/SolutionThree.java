package com.leetcode.bytedance.array;

/**
 * 题目：搜索旋转排序数组
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 解题思路：开始倒排的数组位置为d,  数组位置转化：i->(i+d)%n，位置为i的数据位置变化后为(i+d)%n
 * 通过二分查找的方式进行查找
 *
 */
public class SolutionThree {

    public int search(int[] nums, int target) {

        if(nums == null || nums.length == 0) {
            return -1;
        }

        int d = 0;
        for(int i=1; i< nums.length; ++i) {
            if(nums[i] < nums[i-1]) {
                d = i;
            }
        }

        return cal(nums, target, d, 0, nums.length);
    }

    private int cal(int[] nums, int target, int d, int start, int end) {
        if(start > end) {
            return -1;
        }

        int n = nums.length;
        int mid = start + (end - start) / 2;

        // 获取在数据中的真实位置
        int index = (mid + d) % n;

        if(nums[index] == target) {
            return index;
        } else if(nums[index] < target) {
            return cal(nums, target, d, mid + 1, end);
        } else {
            return cal(nums, target, d, start, mid -1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new SolutionThree().search(nums, 0));
    }

}