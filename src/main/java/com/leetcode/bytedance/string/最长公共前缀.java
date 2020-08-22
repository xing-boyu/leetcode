package com.leetcode.bytedance.string;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 *
 * 题目：编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 解题思路：遍历第一个字符串，不断增加第一个字符串的前缀长度，直到不是其它字符串的前缀其得到结果
 */
public class 最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        if(strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        String firstStr = strs[0];
        for(int i=0; i< firstStr.length(); ++i) {
            sb.append(firstStr.charAt(i));
            for(String str : strs) {
                if(!str.startsWith(sb.toString())) {
                    sb = new StringBuilder(sb.subSequence(0, sb.length()-1));
                    return sb.toString();
                }
            }
        }

        if(sb.length() > 0) {
            return sb.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new 最长公共前缀().longestCommonPrefix(new String[]{"c","acc","ccc"}));
    }

}