package com.leetcode.bytedance.array;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1034/
 *
 * 题目：岛屿的最大面积
 *
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 *
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 * 解题思路：定义一个标识数组f表示是否已经遍历过，然后碰到grid数组中值为1开始进行深度遍历，
 * 找出其中最大深度遍历层数即是最大的岛屿面积
 *
 */
public class 岛屿的最大面积 {

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] f = new boolean[50][50];

        int max = 0;
        for(int i=0; i<grid.length; ++i) {
            for(int j=0; j<grid[i].length; ++j) {
                if(f[i][j] || grid[i][j] == 0) {
                    continue;
                }
                int sum = cal(grid, i, j, f);
                if(max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    private int cal(int[][] p, int i, int j, boolean[][] flag) {
        if(flag[i][j] || p[i][j] == 0) {
            return 0;
        }

        flag[i][j] = true;

        int sum = 1;

        /* 向上遍历 */
        if(i>0 && !flag[i-1][j] && p[i-1][j] == 1) {
            sum += cal(p, i-1, j, flag);
        }
        /* 向下遍历 */
        if(i<p.length-1 && !flag[i+1][j] && p[i+1][j] == 1) {
            sum += cal(p, i+1, j, flag);
        }
        /* 向左遍历 */
        if(j>0 && !flag[i][j-1] && p[i][j-1] == 1) {
            sum += cal(p, i, j-1, flag);
        }
        /* 向右遍历 */
        if(j<p[i].length-1 && !flag[i][j+1] && p[i][j+1] == 1) {
            sum += cal(p, i, j+1, flag);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] p = new int[][] {{1, 0, 1, 0},{0,1,1,1,},{0,1,0,0}};
        System.out.println(new 岛屿的最大面积().maxAreaOfIsland(p));
    }

}