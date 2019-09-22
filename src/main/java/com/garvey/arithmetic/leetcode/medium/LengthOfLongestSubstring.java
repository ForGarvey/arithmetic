package com.garvey.arithmetic.leetcode.medium;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @Description 无重复字符的最长子串
 * @Author Garvey
 * @Date 2019-09-22 22:21
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (queue.contains(c)) {
                maxLength = Math.max(maxLength, queue.size());
                while (queue.contains(c)) {
                    queue.poll();
                }
            }
            queue.offer(c);
        }

        return Math.max(maxLength, queue.size());
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(" "));
    }
}
