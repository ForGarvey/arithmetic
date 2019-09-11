package com.garvey.arithmetic.classical;

/**
 * @Description KMP算法
 *      1.解决模式串在文本串是否出现过，以及若是出现时，最早出现的位置的经典算法。
 *      2.kmp方法算法就利用之前判断过信息，通过一个next数组，保存模式串中前后最长公共子序列的长度，
 *      每次回溯时，通过next数组找到，前面匹配过的位置，省去了大量的计算时间。
 * @Author Garvey
 * @Date 2019-09-11 23:32
 */
public class KMP {

    public static int kmp(String str, String dest, int[] next) {
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i-j+1;
            }
        }
        return -1;
    }

    public static int[] next(String dest){
        int[] next = new int[dest.length()];
        next[0] = 0;

        for (int i = 1,j = 0; i < dest.length(); i++) {
            while(j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
