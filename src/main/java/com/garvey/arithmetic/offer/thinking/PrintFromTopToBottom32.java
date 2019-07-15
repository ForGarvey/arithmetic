package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 32.1
 *  从上到下打印二叉树：
 *      从上到下打印二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *      1.从上到下打印二叉树的规律：
 *          ① 每次打印一个节点的时候，如果该节点有子节点，则把该节点的子节点放到一个队列的末尾。
 *          ② 接下来到队列的头部取出最早进入队列的节点，重复前面的打印操作，直至队列中所有的节点都被打印出来。
 * @Author Garvey
 * @Date 2019/7/15 15:47
 */
public class PrintFromTopToBottom32 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    continue;
                }

                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return list;
    }
}
