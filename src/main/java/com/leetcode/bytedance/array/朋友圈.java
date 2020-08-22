package com.leetcode.bytedance.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/243/array-and-sorting/1036/
 *
 * 题目：朋友圈
 *
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 *
 * 示例 2:
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 *
 * 注意：
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 *
 * 解题思路：广度遍历（每个节点作为遍历起点进行遍历，已经遍历过的就不用再进行遍历，如果所有的节点都已遍历完得到结果）
 *
 */
public class 朋友圈 {
    public int findCircleNum(int[][] M) {
        int circleNum = 0;

        boolean[] f = new boolean[M.length];
        for(int i=0; i< M.length; ++i) {
            if(f[i]) {
                continue;
            }
            f[i] = true;
            circleNum++;

            /* 进行广度遍历 */
            Set<Integer> iter = new HashSet<>();
            iter.add(i);
            while (!iter.isEmpty()) {
                Set<Integer> subIter = new HashSet<>();
                for (Integer k : iter) {
                    for (int j = 0; j < M[i].length; ++j) {
                        if(f[j]) {
                            continue;
                        }
                        if (M[k][j] == 1) {
                            f[j] = true;
                            subIter.add(j);
                        }
                    }
                }
                iter = subIter;
            }
        }
        return circleNum;
    }

    public static void main(String[] args) {
        int[][] M = new int[][]{{1,1,0},
                {1,1,0},
                {0,0,1}};
        int r = new 朋友圈().findCircleNum(M);
        System.out.println(r);
    }
}
