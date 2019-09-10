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
        String str2 = new String("str") + new String("01");

        str2.intern();

        String str1 = "str01";

        System.out.println(str2 == str1);
    }

    @Test
    public void aboutIntern2() {
        String str2 = new String("str") + new String("01");

        String str1 = "str01";

        str2.intern();

        System.out.println(str2 == str1);
    }

    @Test
    public void aboutStringAdd1() {
        String s= "abc";
        String s1 = new String("abc");
        String s2 = "a" + "b" + "c";
        String s3 = "a" + new String("b") + "c";
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }
}
