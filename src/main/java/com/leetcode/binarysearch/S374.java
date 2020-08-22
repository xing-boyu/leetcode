package com.leetcode.binarysearch;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/submissions/
 */
public class S374 {

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l<=r) {
            int m = l + ((r-l)>>1);
            int ret = guess(m);
            if(ret == 0) {
                return m;
            } else if(ret == 1) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return -1;
    }

    int guess(int num) {
        if(num == 6) {
            return 0;
        } else if(num > 6) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new S374().guessNumber(10));
    }

}
