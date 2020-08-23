package com.leetcode.dynamicprogram;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class S322 {

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
            return -1;
        }
        /*int[] r = new int[amount+1];
        return coinChangeMinNum(coins, amount, r);*/
        return dynamicProgramAlg(coins, amount);
    }

    /**
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    private int dynamicProgramAlg(int[] coins, int amount) {
        int[] r = new int[amount+1];
        for(int a=1; a<=amount; ++a) {
            int minNum = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; ++i) {
                if (a >= coins[i] && r[a-coins[i]] != -1) {
                    if(r[a - coins[i]] + 1 < minNum) {
                        minNum = r[a-coins[i]] + 1;
                    }
                }
            }
            int minCoins = minNum == Integer.MAX_VALUE ? -1 : minNum;
            if(r[a] == 0 || r[a] > minNum) {
                r[a] = minCoins;
            }
        }
        return r[amount];
    }

    /**
     * 回溯+备忘录
     *
     * @param coins
     * @param amount
     * @param r 备忘录数组
     * @return
     */
    private int coinChangeMinNum(int[] coins, int amount, int r[]) {
        if(amount == 0) {
            return 0;
        }
        if(r[amount] != 0) {
            return r[amount];
        }

        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; ++i) {
            if(amount - coins[i] < 0) {
                continue;
            }
            int minNum = 1 + coinChangeMinNum(coins, amount - coins[i], r);
            if(minNum == 0) {
                continue;
            }
            if (minCoins > minNum) {
                minCoins = minNum;
            }
        }
        minCoins = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        if(r[amount] == 0 || r[amount] > minCoins) {
            r[amount] = minCoins;
        }
        return minCoins;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(new S322().coinChange(coins, amount));
    }

}
