package com.garvey.arithmetic.offer.ability;

/**
 * @Description 58.2
 *  左旋转字符串：
 *      字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *      1.比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *      2.可以把字符串根据n分为两个部分，由于想把它的前n个字符移到后面，我们就把前两个字符分到第一部分，把后面的所有字符分到第二部分：
 *          ① 先分别翻转这两部分。
 *          ② 然后翻转整个字符串，即可得到原始字符串左旋转两位的结果。
 *      3.为了程序的健壮性，要判断字符串以及n是否合法。
 * @Author Garvey
 * @Date 2019/8/7 14:10
 */
public class LeftRotateString58 {

    public String leftRotateString(String str, int n) {
        if (str == null || str.isEmpty() || n < 0 || n > str.length()) {
            return  "";
        }

        char[] chars = str.toCharArray();

        reverse(chars, 0, n - 1);
        reverse(chars, n, str.length() - 1);
        reverse(chars, 0, str.length() - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        LeftRotateString58 leftRotateString58 = new LeftRotateString58();
        System.out.println(leftRotateString58.leftRotateString("abcdefg", 2));
    }
}
