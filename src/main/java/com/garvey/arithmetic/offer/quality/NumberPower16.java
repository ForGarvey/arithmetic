package com.garvey.arithmetic.offer.quality;

/**
 * @Description 16
 *  数值的整数次方
 *      给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 *      1.因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
 * @Author Garvey
 * @Date 2019/6/17 11:31
 */
public class NumberPower16 {

    public static void main(String[] args) {
        NumberPower16 numberPower16 = new NumberPower16();
        System.out.println(numberPower16.numberPower(3, -3));
    }

    /**
     * 数值的整数次方
     * @param base      基数
     * @param exponent  次方
     * @return
     */
    public double numberPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        // 判断
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        // 右移一位等于除以二
        double pow = numberPower(base * base, exponent >> 1);
        if ((exponent & 0x1) == 1 ) {
            // 说明次方除以2还余1
            pow *= base;
        }
        return isNegative ? 1 / pow : pow;
    }
}
