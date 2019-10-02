package com.garvey.arithmetic.leetcode.easy;

/**
 * @Description 水壶问题
 * @Author Garvey
 * @Date 2019-10-02 13:39
 */
public class CanMeasureWater {

    /**
     * 判断z能否被x和y的最大公约数整除
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z || x == 0 || y == 0) {
            return false;
        }
        return z % gcd(x, y) == 0;
    }

    /**
     * 求x和y的最大公约数
     * @param x
     * @param y
     * @return
     */
    private int gcd(int x, int y) {
        if (x == y) {
            return x;
        } else if (x < y) {
            return gcd(y, x);
        } else {
            if ((x & 1) == 0 && (y & 1) == 0) {
                return 2 * gcd(x >> 1, y >> 1);
            } else if ((x & 1) == 0 && (y & 1) == 1) {
                return gcd(x >> 1, y);
            } else if ((x & 1) == 1 && (y & 1) == 0) {
                return gcd(x, y >> 1);
            } else {
                return gcd(y, x - y);
            }
        }
    }

    public static void main(String[] args) {
        CanMeasureWater canMeasureWater = new CanMeasureWater();
        System.out.println(canMeasureWater.canMeasureWater(2, 6, 5));
    }
}
