package com.garvey.arithmetic.offer.efficiency;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 45
 *  把数组排成最小的数：
 *      输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *      1.例如，输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323。
 *      2.这是一个隐形的大数问题：m和n都在int型能表达的范围内，但把它们拼接起来的数字mn和nm用int型表示就有可能溢出了。
 *      一个非常直观的解决大数问题的方法就是把数字转换成字符串。另外，由于把数字m和n拼接起来得到mn和nm，它们的位数肯定是相同的，
 *      因此比较它们的大小只需要按照字符串大小的比较规则就可以了。
 *      3.可以看成是一个排序问题，在比较两个字符串 S1 和 S2 的大小时，应该比较的是 S1+S2 和 S2+S1 的大小，
 *      如果 S1+S2 < S2+S1，那么应该把 S1 排在前面，否则应该把 S2 排在前面。
 * @Author Garvey
 * @Date 2019-07-28 20:57
 */
public class PrintMinNumber45 {

    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length <= 0) {
            return "";
        }

        List<String> sortedList = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                .collect(Collectors.toList());

        return String.join("", sortedList);
    }

    public static void main(String[] args) {
        PrintMinNumber45 printMinNumber45 = new PrintMinNumber45();
        System.out.println(printMinNumber45.printMinNumber(new int[]{3,32,321}));
    }
}
