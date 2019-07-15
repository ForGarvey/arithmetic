package com.garvey.arithmetic.offer.thinking;

import java.util.Stack;

/**
 * @Description 31
 *  栈的压入、弹出序列：
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *      例如，序列{1,2,3,4,5}是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4,3,5,1,2}就不可能是该压栈序列的弹出序列。
 *      1.建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从该栈中弹出数字。
 *      2.如何判断一个序列是不是栈的弹出序列的规律：
 *          ① 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
 *          ② 如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止；
 *          ③ 如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列就不可能是一个弹出序列。
 * @Author Garvey
 * @Date 2019/7/15 14:27
 */
public class StackPushAndPopSequence31 {

    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        boolean possible = false;

        if (pushSequence != null && popSequence != null) {
            Stack<Integer> stack = new Stack<>();

            for (int pushIndex = 0, popIndex = 0; pushIndex < pushSequence.length; pushIndex++) {
                stack.push(pushSequence[pushIndex]);

                while (popIndex < popSequence.length && !stack.isEmpty() && stack.peek() == popSequence[popIndex]) {
                    stack.pop();
                    popIndex++;
                }
            }

            possible = stack.isEmpty();
        }

        return possible;
    }
}
