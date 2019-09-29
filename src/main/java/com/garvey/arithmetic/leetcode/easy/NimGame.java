package com.garvey.arithmetic.leetcode.easy;

/**
 * @Description Nim游戏，即取物游戏
 * @Author Garvey
 * @Date 2019-09-29 20:33
 */
public class NimGame {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}