package com.garvey.arithmetic.offer;

/**
 * @Description 10
 *  斐波那契数列：
 *      求斐波那契数列的第 n 项，n <= 39。
 *      1.n = 0 -> f(n) = 0
 *      2.n = 1 -> f(n) = 1
 *      3.n > 1 -> f(n) = f(n-1) + f(n-2)
 *      4.如果使用递归求解，会重复计算一些子问题。
 *        例如，计算 f(4) 需要计算 f(3) 和 f(2)，计算 f(3) 需要计算 f(2) 和 f(1)，可以看到 f(2) 被重复计算了。
 *      5.递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 * @Author Garvey
 * @Date 2019/5/22 11:51
 */
public class Fibonacci10 {

    /*// ①递归（这里其实是动态规划） 从上往下会有很多重复计算，虽然清晰但是效率低，所以这里是从下往上计算
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }*/

    // ②考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    // ③由于待求解的 n 小于 40，因此可以将前 40 项的结果先进行计算，之后就能以 O(1) 时间复杂度得到第 n 项的值。
    /*private int[] fib = new int[40];

    public fibonacci() {
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }

    public int fibonacci(int n) {
        return fib[n];
    }*/
}
