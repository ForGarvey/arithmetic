package com.garvey.arithmetic.offer.efficiency;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 50.2
 *  字符流中第一个只出现一次的字符：
 *      请实现一个函数，用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'；
 *      当从该字符流中读出前6个字符"google"时，第一个只出现一次的字符是'l'。
 *      1.此题和同一目录下的FirstAppearingOnceOfStream41重复。（其实FirstAppearingOnceOfStream41应该是在这个位置，就当复习了）
 *      2.可以借鉴50.1的思想，只出现一次意味着我们只要区分：0、1和更多这三种情况，所以我们不用41的Map来存储，而是用BitSet。
 * @Author Garvey
 * @Date 2019/8/1 9:52
 */
public class FirstNotRepeatingCharOfStream50 {

    /**
     * 字符出现一次，则该BitSet对应位置元素为true
     */
    private BitSet bitSet1 = new BitSet(256);

    /**
     * 字符出现两次及以上，则该BitSet对应位置元素为true
     */
    private BitSet bitSet2 = new BitSet(256);

    /**
     * 第一次只出现一次，所以类似于先进先出的概念，所以用队列存储只出现了一次的字符
     */
    private Queue<Character> charQueue = new LinkedList<>();

    /**
     * 读取字符流中的字符
     * @param ch
     */
    public void insert(char ch) {
        // charQueue是否需要poll
        boolean needPollFlag = true;

        if (!bitSet1.get(ch) && !bitSet2.get(ch)) {
            // 说明字符此时是第一次出现
            bitSet1.set(ch);
            charQueue.offer(ch);
            needPollFlag = false;
        } else if (bitSet1.get(ch) && !bitSet2.get(ch)) {
            // 说明字符此时是第二次出现
            bitSet2.set(ch);
        }

        if (needPollFlag) {
            while (!charQueue.isEmpty() && bitSet1.get(charQueue.peek()) && bitSet2.get(charQueue.peek())) {
                charQueue.poll();
            }
        }
    }

    /**
     * 获取字符流中第一个只出现一次的字符
     * @return
     */
    public char firstNotRepeatingCharOfStream() {
        return charQueue.isEmpty() ? '\0' : charQueue.peek();
    }

    public static void main(String[] args) {
        FirstNotRepeatingCharOfStream50 firstNotRepeatingCharOfStream50 = new FirstNotRepeatingCharOfStream50();

        String str = "google";
        for (char c : str.toCharArray()) {
            firstNotRepeatingCharOfStream50.insert(c);
            System.out.println(firstNotRepeatingCharOfStream50.firstNotRepeatingCharOfStream());
        }

    }

}
