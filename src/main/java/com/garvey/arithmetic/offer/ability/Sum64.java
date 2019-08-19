package com.garvey.arithmetic.offer.ability;

/**
 * @Description 64
 *  求1+2+...+n：
 *      求1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A ? B : C）。
 * @Author Garvey
 * @Date 2019/8/19 19:10
 */
public class Sum64 {

    public int sum(int n) {
        boolean b = n > 0 && (n += sum(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Sum64 sum64 = new Sum64();
        System.out.println(sum64.sum(5));
        System.out.println(sum64.sum(10));
    }
}
