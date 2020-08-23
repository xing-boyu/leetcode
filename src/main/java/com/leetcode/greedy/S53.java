package com.leetcode.greedy;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 解题思路：如果sum[i-1]>0 sum[i]=sum[i-1]+num[i] 否则sum[i]=num[i]
 */
public class S53 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int sum = nums[0];
        for(int i=1; i<nums.length; ++i) {
            if(sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            if(maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new S53().maxSubArray(nums));
    }

}
