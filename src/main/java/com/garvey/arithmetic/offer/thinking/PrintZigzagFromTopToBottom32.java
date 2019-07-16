package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 32.3
 *  之字形打印二叉树：
 *      请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 *      第三行再按照从左到右的顺序打印，其他行以此类推。
 *      1.按之字形顺序打印二叉树的过程比较复杂，如果在短时间内找不到解决办法，则建议可以试着用具体的例子一步步分析。
 *      2.当二叉树的根节点（节点1）打印之后，它的左子节点（节点2）和右子节点（节点3）先后保存到以后数据容器里。
 *      值得注意的是，在打印第二层的节点时，先打印节点3，再打印节点2.看起来节点在这个数据容器里是后进先出的，
 *      因此这个数据容器可以用栈来实现。
 *      3.按之字形顺序打印二叉树需要两个栈。在打印某一层的节点时，把下一层的这些子节点保存到相应的栈里：
 *          ① 如果当前打印的是奇数层（第一层、第三层等），则先保存左子节点再保存右子节点到第一个栈里；
 *          ② 如果当前打印的是偶数层（第二层、第四层等），则先保存右子节点再保存左子节点到第二个栈里。
 *      4.我们也可以使用队列，在偶数层的时候使打印的顺序（list）反转即可。
 * @Author Garvey
 * @Date 2019/7/16 11:34
 */
public class PrintZigzagFromTopToBottom32 {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (pRoot != null) {
            int line = 1;
            Stack<TreeNode> oddStack = new Stack<>();
            Stack<TreeNode> evenStack = new Stack<>();

            evenStack.push(pRoot);

            while (!oddStack.empty() || !evenStack.empty()) {
                ArrayList<Integer> subList = new ArrayList<>();

                if (line % 2 == 1) {
                    while (!evenStack.empty()) {
                        TreeNode node = evenStack.pop();
                        if (node != null) {
                            subList.add(node.val);
                            System.out.print(node.val);
                            // 当前打印的是奇数层（第一层、第三层等），则先保存左子节点再保存右子节点到第一个栈里；
                            oddStack.push(node.left);
                            oddStack.push(node.right);
                        }
                    }
                } else {
                    while (!oddStack.empty()) {
                        TreeNode node = oddStack.pop();
                        if (node != null) {
                            subList.add(node.val);
                            System.out.print(node.val);
                            // 当前打印的是偶数层（第二层、第四层等），则先保存右子节点再保存左子节点到第二个栈里。
                            evenStack.push(node.right);
                            evenStack.push(node.left);
                        }
                    }
                }
                if (subList.size() > 0) {
                    list.add(subList);
                }
                line++;
                System.out.println();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node5.left = node10;
        node5.right = node11;

        node6.left = node12;
        node6.right = node13;

        node7.left = node14;
        node7.right = node15;

        PrintZigzagFromTopToBottom32 zigzag = new PrintZigzagFromTopToBottom32();
        zigzag.print(node1);
    }

    /**
     * 用队列的反转
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            ArrayList<Integer> sublist = new ArrayList<>();
            int count = queue.size();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sublist.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (reverse) {
                Collections.reverse(sublist);
            }
            reverse = !reverse;
            if (sublist.size() > 0) {
                list.add(sublist);
            }
        }
        return list;
    }
}
