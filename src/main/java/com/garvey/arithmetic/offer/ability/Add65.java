package com.garvey.arithmetic.offer.ability;

/**
 * @Description 65
 *  不用加减乘除做加法：
 *      写一个函数，求两个整数之和，要求在函数体内不得使用“+”、“-”、“*”、“/"四则运算符号。
 *      1.使用位运算。
 *          ① 第一步不考虑进位对每一位想加，这和异或的结果是一样的。
 *          ② 第二步进位，可以想象成两个数先做位与运算，然后再向左移动一位。
 *          ③ 第三步把前两个步骤的结果相加，然后重复前面两步，直到不产生进位为止（即第二步获得的数为0）。
 * @Author Garvey
 * @Date 2019/8/19 19:21
 */
public class Add65 {

    public int add(int a, int b) {
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Add65 add65 = new Add65();
        System.out.println(add65.add(3, 15));
    }

}
