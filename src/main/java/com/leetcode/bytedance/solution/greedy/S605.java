package com.leetcode.bytedance.solution.greedy;

/**
 * https://leetcode-cn.com/problems/can-place-flowers/
 */
public class S605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0) {
            return false;
        }

        int s = 0;
        if(flowerbed.length == 1) {
            if(flowerbed[0] == 0) {
                return 1 >= n;
            }
        }

        for(int i=0; i<flowerbed.length; ++i) {
            if(flowerbed[i] == 1) {
                continue;
            }
            if(i==0) {
                if(flowerbed[i+1] == 0) {
                    flowerbed[0] = 1;
                    s++;
                }
                continue;
            }
            if(i == flowerbed.length - 1) {
                if(flowerbed[i-1] == 0) {
                    flowerbed[i]=1;
                    s++;
                }
                continue;
            }
            if(i+1 < flowerbed.length && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                flowerbed[i]=1;
                s++;
            }
        }

        return s >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,1};
        int n = 2;
        System.out.println(new S605().canPlaceFlowers(flowerbed, n));
    }

}
