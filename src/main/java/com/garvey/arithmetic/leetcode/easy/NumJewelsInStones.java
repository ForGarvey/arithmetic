package com.garvey.arithmetic.leetcode.easy;

import java.util.Objects;

/**
 * @Description 宝石与石头
 * @Author Garvey
 * @Date 2019-09-21 21:09
 */
public class NumJewelsInStones {

    /**
     * 计算你拥有的石头中，有多少宝石
     * @param j     代表石头中宝石的类型
     * @param s     代表你拥有的石头
     * @return      拥有的宝石数
     */
    public int numJewelsInStones(String j, String s) {
        // 参数校验必不可少，提高程序的健壮性
        if (Objects.isNull(j) || j.isEmpty() || Objects.isNull(s) || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        char[] sCharArr = s.toCharArray();
        for (char sChar : sCharArr) {
            if (j.indexOf(sChar) != -1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
        System.out.println(numJewelsInStones.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones.numJewelsInStones("z", "ZZ"));
    }
}
