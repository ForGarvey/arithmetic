package com.garvey.arithmetic.other;

import org.junit.Test;

/**
 * @Description
 * @Author Garvey
 * @Date 2019-09-10 23:08
 */
public class AboutString {

    @Test
    public void aboutIntern1() {
        String str2 = new String("str")+new String("01");

        str2.intern();

        String str1 = "str01";

        System.out.println(str2 == str1);
    }

    @Test
    public void aboutIntern2() {
        String str2 = new String("str")+new String("01");

        String str1 = "str01";

        str2.intern();

        System.out.println(str2 == str1);
    }
}
