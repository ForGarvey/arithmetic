package com.garvey.arithmetic.offer.thinking;

import java.util.Stack;

/**
 * @Description 30
 *  包含min函数的栈：
 *      定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 *      1.当最小元素被弹出栈的时候，我们希望能够得到次小元素。因此在压入这个最小元素之前，我们要把次小元素保存起来。
 * @Author Garvey
 * @Date 2019-07-14 21:52
 */
public class StackWithMin30 {

    /**
     * 数据栈：保存压入的数据
     */
    private Stack<Integer> dataStack = new Stack<>();

    /**
     * 辅助栈：每次有数据压入数据栈时，把之前的最小元素和新压入数据栈的元素两者的较小值压入辅助栈。
     */
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
