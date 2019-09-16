package com.garvey.arithmetic.interview;

/**
 * @Description 缩写校验
 * @Author Garvey
 * @Date 2019-09-16 22:11
 */
public class ValidAbbr {

    public static boolean valid(String word, String abbr) {
        if (word == null || word.isEmpty()
                || abbr == null || abbr.isEmpty()) {
            return false;
        }

        char[] wordChars = word.toCharArray();
        char[] abbrChars = abbr.toCharArray();

        int i = 0, j = 0;
        StringBuilder count = new StringBuilder();

        while (i < wordChars.length) {
            count.delete(0, count.length());

            // 拼接数字
            while (Character.isDigit(abbrChars[j])) {
                // 内循环循环两次，外循环将少循环至少10次
                count.append(abbrChars[j]);
                j++;
            }

            if (count.length() > 0) {
                i += Integer.valueOf(count.toString());
            } else {
                if (wordChars[i] != abbrChars[j]) {
                    return false;
                }
                i++;
                j++;
            }
        }

        if (i == wordChars.length) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(valid("internationalization", "i12iz4n"));
        System.out.println(valid("apple", "a2e"));
    }

}
