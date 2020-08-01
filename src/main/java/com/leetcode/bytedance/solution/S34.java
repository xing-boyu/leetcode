package com.leetcode.bytedance.solution;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class S34 {

    public int[] searchRange(int[] nums, int target) {
        int [] ret = new int[]{-1, -1};
        if(nums == null || nums.length == 0) {
            return ret;
        }

        int l=0, r=nums.length-1;
        while (l <= r) {
            int m = l + ((r-l)>>1);
            if(nums[m] < target) {
                l=m+1;
            } else if(nums[m] > target) {
                r=m-1;
            } else {
                int i;
                for (i=m; i>=0; --i) {
                    if(nums[i] != target) {
                        break;
                    }
                }
                ret[0] = i+1;
                for (i=m; i<nums.length; ++i) {
                    if(nums[i] != target) {
                        break;
                    }
                }
                ret[1] = i-1;
                break;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        System.out.println(Arrays.toString(new S34().searchRange(nums, target)));
    }

}
