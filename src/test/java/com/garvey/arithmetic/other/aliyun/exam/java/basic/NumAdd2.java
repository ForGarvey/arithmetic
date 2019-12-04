package com.garvey.arithmetic.other.aliyun.exam.java.basic;

import org.junit.Test;

/**
 * @Description
 * @Author Garvey
 * @Date 2019/12/4 17:42
 */
public class NumAdd2 {

    @Test
    public void numAdd2 () {
        int num = 2147483647;
        num += 2;
        // -2147483647
        System.out.println(num);
    }

    @Test
    public void numAdd2L () {
        int num = 2147483647;
        num += 2L;
        // -2147483647
        System.out.println(num);
    }
}
