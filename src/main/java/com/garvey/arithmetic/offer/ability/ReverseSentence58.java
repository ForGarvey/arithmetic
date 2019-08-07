package com.garvey.arithmetic.offer.ability;

/**
 * @Description 58.1
 *  翻转字符串：翻转单词顺序
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 *      1.例如输入字符串"I am a student."，则输出"student. a am I"。
 *      2.这道题目流传甚广，很多公司多次拿来作为面试题，主要解法是两次翻转字符串。
 *      3.第一步翻转句子中所有的字符，此时不但翻转了句子中单词的顺序，连单词内的字符顺序也被翻转了。
 *      4.第二步翻转每个单词中字符的顺序，在英语句子中，单词被空格号分隔，因此我们可以通过扫描空格来确定每个单词的起始和终止位置。
 *      5.题目应该有一个隐含条件，就是不能用额外的空间。虽然 Java 的题目输入参数为 String 类型，需要先创建一个字符数组使得空间复杂度为 O(N)，
 *      但是正确的参数类型应该和原书一样，为字符数组，并且只能使用该字符数组的空间。任何使用了额外空间的解法在面试时都会大打折扣，包括递归解法。
 * @Author Garvey
 * @Date 2019/8/6 16:54
 */
public class ReverseSentence58 {

    public String reverseSentence(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        char[] chars = str.toCharArray();

        // 翻转句子中所有的字符
        reverse(chars, 0, chars.length - 1);

        // 翻转每个单词中字符的顺序
        int i = 0, j = 0;
        while (j <= chars.length) {
            // if语句里面的判断顺序不能改，如果char[j]放在前面，那么当j等于chars.length的时候，会报ArrayIndexOutOfBoundsException
            if (j == chars.length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }

            j++;
        }
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
        ReverseSentence58 reverseSentence58 = new ReverseSentence58();
        System.out.println(reverseSentence58.reverseSentence("student. a am I"));
        System.out.println(reverseSentence58.reverseSentence("I am a student."));
    }

}
