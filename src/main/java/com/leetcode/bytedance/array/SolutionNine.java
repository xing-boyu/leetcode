package com.leetcode.bytedance.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 题目: 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 解题思路：按照第一个数字进行排序，最终遍历一遍数组得到结果
 *
 */
public class SolutionNine {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return new int[0][0];
        }
        if(intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        int l=intervals[0][0];
        int r=intervals[0][1];
        for(int i=1; i<intervals.length; ++i) {
            if(r >= intervals[i][0] && r<intervals[i][1]) {
                r = intervals[i][1];
            }
            if(r < intervals[i][0]){
                res.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            }
        }
        res.add(new int[]{l, r});

        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6}};
        int[][] r = new SolutionNine().merge(intervals);
        System.out.println(Arrays.deepToString(r));
    }
}
