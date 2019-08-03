package com.garvey.arithmetic.offer.ability;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 55.1
 *  二叉树的深度：
 *      输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点依次经过的节点（含根、叶节点）
 *      形成的一条路径，最长路径的长度为树的深度。
 *      1.递归，较大子树的深度+1。
 * @Author Garvey
 * @Date 2019-08-03 15:05
 */
public class BinaryTreeDepth55 {

    public int treeDepth(TreeNode pRoot) {
        return pRoot == null ? 0 : 1 + Math.max(treeDepth(pRoot.left), treeDepth(pRoot.right));
    }

}
