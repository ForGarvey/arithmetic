package com.garvey.arithmetic.offer.efficiency;

import java.util.BitSet;
import java.util.Map;

/**
 * @Description 50.1
 *  第一个只出现一次的字符：
 *      在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 *      1.使用数组或者哈希表。哈希表的键是字符，值是该字符出现的次数。从头开始扫描字符串两次。第一次扫描字符串时，每扫描到一个字符，就在哈希表的对应项中把次数加1。
 *      接下来第二次扫描时，每扫描到一个字符，就能从哈希表中得到该字符出现的次数，第一个只出现一次的字符就是符合要求的输出。
 *      2.时间复杂度O(n)，空间复杂度O(1)（因为辅助数组的大小是一个常数）。
 *      3.用数组或者哈希表实现的方法，空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0、1、更大，所以使用两个比特位就能存储这些信息。可以使用BitSet类。
 * @Author Garvey
 * @Date 2019/7/31 16:21
 */
public class FirstNotRepeatingChar50 {

    /**
     * 使用数组存储字符出现次数
     * @param str
     * @return
     */
    public char firstNotRepeatingCharSolution1(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }

        int[] arr = new int[256];

        for (char c : str.toCharArray()) {
            arr[c]++;
        }

        for (char c : str.toCharArray()) {
            if (arr[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    /**
     * 使用BitSet字符出现次数
     * @param str
     * @return
     */
    public char firstNotRepeatingCharSolution2(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }

        BitSet bitSet1 = new BitSet(256);
        BitSet bitSet2 = new BitSet(256);

        for (char c : str.toCharArray()) {
            if (!bitSet1.get(c) && !bitSet2.get(c)) {
                bitSet1.set(c);
            } else if (bitSet1.get(c) && !bitSet2.get(c)) {
                bitSet2.set(c);
            }
        }

        for (char c : str.toCharArray()) {
            if (bitSet1.get(c) && !bitSet2.get(c)) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar50 firstNotRepeatingChar50 = new FirstNotRepeatingChar50();
        System.out.println(firstNotRepeatingChar50.firstNotRepeatingCharSolution1(""));
        System.out.println(firstNotRepeatingChar50.firstNotRepeatingCharSolution1("abaccdeff"));
        System.out.println(firstNotRepeatingChar50.firstNotRepeatingCharSolution2("abbdaccdeff"));
    }

}
