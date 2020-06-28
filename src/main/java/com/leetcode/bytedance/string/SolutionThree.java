package com.leetcode.bytedance.string;

/**
 * 题目：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 解题思路：将s1分为已经匹配完成和待匹配的字符串，当待匹配字符串中无字符后表示匹配成功。（主要都是字符串处理）
 */
public class SolutionThree {

    /**
     * 题目说明已经说了非空，入参就不判断了。
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        StringBuilder checkStr = new StringBuilder();
        StringBuilder unCheckStr = new StringBuilder(s1);
        for(int i=0; i<s2.length(); ++i) {
            String sub = String.valueOf(s2.charAt(i));
            int index = unCheckStr.toString().indexOf(sub);
            if(index >= 0) {
                checkStr.append(unCheckStr.toString().charAt(index));
                StringBuilder sb = new StringBuilder(unCheckStr.substring(0, index));
                sb.append(unCheckStr.subSequence(index + 1, unCheckStr.length()));
                unCheckStr = sb;
                if(unCheckStr.length() == 0) {
                    return true;
                }
                continue;
            }
            if(checkStr.length() > 0) {
                unCheckStr.append(checkStr.charAt(0));
                checkStr = new StringBuilder(checkStr.subSequence(1, checkStr.length()));
                --i;
            }
        }
        return unCheckStr.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionThree().checkInclusion("ab", "eidboaoo"));
    }
}