package com.leetcode.bytedance.string;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 *
 * 题目：无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 解题思路：sb标识已经匹配完成的子串，当出现重复字符串说明已经达到当前子串的最大长度，记录后再往后继续匹配，
 * 当遍历完字符串后拿到子串中最长的长度输出
 */
public class 无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        int length = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (sb.toString().contains(c)) {
                if (length > maxLength) {
                    maxLength = length;
                }
                sb = new StringBuilder(sb.subSequence(1, sb.length()));
                --length;
                --i;
                continue;
            }
            ++length;
            sb.append(c);
        }

        return maxLength > length ? maxLength : length;
    }

    public static void main(String[] args) {
        System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring("aab"));
    }

}