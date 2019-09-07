package com.garvey.arithmetic.other;

import org.junit.Test;

/**
 * @Description
 * @Author Garvey
 * @Date 2019-09-07 09:22
 */
public class AboutAdd {

    @Test
    public void aboutAdd() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }

}
