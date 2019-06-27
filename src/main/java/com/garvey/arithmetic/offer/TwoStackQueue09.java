package com.garvey.arithmetic.offer;

import java.util.Stack;

/**
 * @Description 09
 *  用两个栈实现队列：
 *      用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。
 *      1.in 栈用来处理入栈（push）操作，out 栈用来处理出栈（pop）操作。
 *      2.一个元素进入 in 栈之后，出栈的顺序被反转。当元素要出栈时，需要先进入 out 栈，
 *      此时元素出栈顺序再一次被反转，因此出栈顺序就和最开始入栈顺序是相同的，先进入的元素先退出，这就是队列的顺序。
 *      3.添加元素都先入in栈。删除元素时要先判断out栈是否为空，不为空就直接从out栈pop，否则先将in栈元素push到out栈再进行pop。
 * @Author Garvey
 * @Date 2019/5/21 16:13
 */
public class TwoStackQueue09 {

    Stack<Integer> in = new Stack<>();

    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (out.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return out.pop();
    }
}
