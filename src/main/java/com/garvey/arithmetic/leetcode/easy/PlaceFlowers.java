package com.garvey.arithmetic.leetcode.easy;

import java.util.Objects;

/**
 * @Description 种花问题
 * @Author Garvey
 * @Date 2019-10-03 15:56
 */
public class PlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (Objects.isNull(flowerbed) || n > flowerbed.length) {
            return false;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) {
                break;
            }

            if (flowerbed[i] == 0 && (i - 1 == -1 || flowerbed[i - 1] == 0)
                    && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
