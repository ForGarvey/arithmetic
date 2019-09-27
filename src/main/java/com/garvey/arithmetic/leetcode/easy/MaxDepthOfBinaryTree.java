package com.garvey.arithmetic.leetcode.easy;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 二叉树的最大深度
 * @Author Garvey
 * @Date 2019-09-27 23:25
 */
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
