package com.garvey.arithmetic.offer.efficiency;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Description 41.2
 *  字符流中第一个不重复的字符：
 *      请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *      1.例如，当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 *      当从该字符流中读出前六个字符 "google" 时，第一个只出现一次的字符是 "l"。
 *      2.如果当前字符流没有存在出现一次的字符，返回#字符。
 * @Author Garvey
 * @Date 2019/7/25 11:16
 */
public class FirstAppearingOnceOfStream41 {

    /**
     * 存放字符以及字符出现次数
     */
    private Map<Character, Integer> charCountMap = new HashMap<>();

    /**
     * 第一次只出现一次，所以类似于先进先出的概念，所以用队列存储只出现了一次的字符
     */
    private Queue<Character> charQueue = new LinkedList<>();

    public void insert(char ch) {
        if (charCountMap.containsKey(ch)) {
            charCountMap.put(ch, charCountMap.get(ch) + 1);

            // 队列中要弹出出现次数超过一次的字符
            while (!charQueue.isEmpty() && charCountMap.get(charQueue.peek()) > 1) {
                charQueue.poll();
            }
        } else {
            charCountMap.put(ch, 1);
            // 第一次出现的字符，直接加入队列中即可
            charQueue.offer(ch);
        }
    }

    public char firstAppearingOnce() {
        return charQueue.isEmpty() ? '#' : charQueue.peek();
    }
}
