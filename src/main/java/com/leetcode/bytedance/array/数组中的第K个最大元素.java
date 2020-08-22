package com.leetcode.bytedance.array;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1018/
 *
 * 题目：数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 解题思路：1. 选择排序找到第k大个元素
 * 2. 快速排序的思想是找到一个位置左边位置值的都比其小，右边位置的值都比其大，所以刚好如果index == n-k 就是第k大个元素
 */
public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for(int i=n-1; i>n-k-1; --i) {
            int max = i;
            for(int j=i-1; j>=0; --j) {
                if(nums[i] < nums[j] && nums[j] > nums[max]) {
                    max = j;
                }
            }
            int temp = nums[max];
            nums[max] = nums[i];
            nums[i] = temp;
        }

        return nums[n-k];
    }

    public int findKthLargestQuickSort(int[] nums, int k) {
        return quickSort(nums, 0, nums.length, nums.length-k);
    }

    private int quickSort(int[] nums, int start, int end, int k) {
        int p = nums[end-1];
        int i = start;
        for(int j=start; j<end; ++j) {
            if(nums[j] < p) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end-1);

        if(i == k) {
            return nums[i];
        } else if(i < k) {
            return quickSort(nums, i+1, end, k);
        } else {
            return quickSort(nums, start, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(new 数组中的第K个最大元素().findKthLargestQuickSort(nums, 4));
    }

}