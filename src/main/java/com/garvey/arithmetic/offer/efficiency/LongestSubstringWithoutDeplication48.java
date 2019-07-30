package com.garvey.arithmetic.offer.efficiency;

import java.util.Arrays;

/**
 * @Description 48
 *  最长不含重复字符的子字符串：
 *      请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。假设字符串中只包含'a'~'z'的字符。
 *      1.例如，在字符串“arabcacfr”中，最长的不含重复字符的子字符串是“acfr”，长度为4。
 *      2.用动态规划算法来提高效率。
 *          ① 首先定义函数f(i)表示以第i个字符为结尾的不包含重复字符的子字符串的最长长度。我们从左到右逐一扫描字符串中的每个字符。
 *          当我们计算以第i个字符为结尾的不包含重复字符的子字符串的最长长度f(i)时，我们已经知道f(i-1)了。
 *          ② 如果第i个字符之前没有出现过，那么f(i)=f(i-1)+1。
 *          ③ 如果第i个字符之前已经出现过，我们先计算第i个字符和它上次出现在字符串中的位置的距离，并记为d：
 *              1.如果d小于或者等于f(i-1)，此时第i个字符上次出现在f(i-1)对应的最长子字符串之中，因此f(i)=d。
 *              同时这也意味着在第i个字符出现两次所夹的子字符串中再也没有其他重复的字符了。
 *              2.如果d大于f(i-1)，此时第i个字符上次出现在f(i-1)对应的最长子字符串之前，因此仍然有f(i)=f(i-1)+1。
 *      3.下面的解法中，创建了一个长度为26的数组position用来存储每个字符上次出现在字符串中位置的下标。该数组所有元素的值都初始化为-1，
 *      负数表示该元素对应的字符在字符串中还没有出现过。我们在扫描字符串时遇到某个字符，就把该字符在字符串中的位置存储到数组对应的元素中。
 * @Author Garvey
 * @Date 2019/7/30 20:08
 */
public class LongestSubstringWithoutDeplication48 {

    public int longestSubstringWithoutDeplication(String str) {
        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];

        Arrays.fill(position, -1);
        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI) - 'a';
            int preI = position[c];
            if (preI == -1 || curI - preI > curLength) {
                curLength++;
            } else {
                maxLength = Math.max(maxLength, curLength);
                curLength = curI - preI;
            }
            position[c] = curI;
        }
        maxLength = Math.max(maxLength, curLength);
        return maxLength;
    }

}
