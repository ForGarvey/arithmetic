package com.garvey.arithmetic.leetcode.medium;

/**
 * @Description 检查替换后的词是否有效
 * 明天搬家。今后继续努力
 * 搬家完成。加油工作吧
 * 调整好睡眠，好状态才可以好工作
 * @Author Garvey
 * @Date 2019-10-05 23:05
 */
public class IsValid {

    public boolean isValid(String S) {
        while (S.length() > 0 && S.contains("abc"))
            S = S.replace("abc", "");
        return  S.equals("") ;
    }
}
