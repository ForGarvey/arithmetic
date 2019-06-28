package com.garvey.arithmetic.offer.basics;

import com.garvey.arithmetic.offer.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 07
 *  重建二叉树：
 *      根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *      1.前序遍历的第一个值为根节点的值，使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，右部分为树的右子树中序遍历的结果。
 * @Author Garvey
 * @Date 2019/5/21 11:30
 */
public class ReConstructBinaryTree07 {

    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    /**
     * 重建二叉树入口
     * @param pre   前序遍历数组
     * @param in    中序遍历数组
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    /**
     * 重建二叉树递归
     * @param pre   前序遍历数组
     * @param preL  前序遍历左节点索引
     * @param preR  前序遍历右节点索引
     * @param inL   中序遍历左节点索引
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        // 第一次调用是根节点
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

}
