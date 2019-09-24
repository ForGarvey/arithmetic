package com.garvey.arithmetic.leetcode.easy;

/**
 * @Description IP地址无效化
 * @Author Garvey
 * @Date 2019-09-24 23:52
 */
public class DefangIPaddr {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
