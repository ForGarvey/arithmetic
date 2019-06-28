package com.garvey.arithmetic.offer.basics;

/**
 * @Description 10.2
 *  矩形覆盖：
 *      我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
 *      1.原理等同于斐波那契数列
 * @Author Garvey
 * @Date 2019/5/27 14:48
 */
public class RectCover10 {

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int pre1 = 2, pre2 = 1;
        int fib = 0;
        for (int i = 3; i <= target; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
}
