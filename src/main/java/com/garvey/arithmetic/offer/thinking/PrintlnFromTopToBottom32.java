package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 32.2
 *  分行从上到下打印二叉树：
 *      从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *      1.可以用一个队列来保存将要打印的节点。
 *      2.为了把二叉树的每一行单独打印到一行里，我们需要两个变量：
 *          ① 一个变量表示在当前层中还没有打印的节点数；
 *          ② 另一个变量表示下一层节点的数目。
 * @Author Garvey
 * @Date 2019/7/15 17:41
 */
public class PrintlnFromTopToBottom32 {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (pRoot != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(pRoot);

            while (!queue.isEmpty()) {
                ArrayList<Integer> subList = new ArrayList<>();
                int cnt = queue.size();
                while (cnt-- > 0) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        subList.add(node.val);
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
                if (subList.size() > 0) {
                    list.add(subList);
                }
            }
        }

        return list;
    }
}
