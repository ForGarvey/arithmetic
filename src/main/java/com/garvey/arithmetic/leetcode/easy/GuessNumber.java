package com.garvey.arithmetic.leetcode.easy;

import java.util.Objects;

/**
 * @Description 猜数字
 * @Author Garvey
 * @Date 2019-09-27 23:15
 */
public class GuessNumber {

    public int game(int[] guess, int[] answer) {
        if (Objects.isNull(guess) || Objects.isNull(answer)
                || guess.length < 3 || answer.length < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }

        return count;
    }
}
