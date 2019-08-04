package com.garvey.arithmetic.offer.ability;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 55.2
 *  平衡二叉树：
 *      输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左、右子树的深度相差不超过1，
 *      那么它就是一棵平衡二叉树。
 *      1.我们用后序遍历的方式遍历二叉树的每个节点，那么在遍历到一个节点之前我们就已经遍历了它的左、右子树。
 *      只要在遍历每个节点的时候记录它的深度（某一节点的深度等于它到叶节点的路径的长度），我们就可以一边遍历
 *      一边判断每个节点是不是平衡的。
 *      2.为了避免重复计算树的深度，我们需要从叶节点开始计算。递归方法的返回值应该是深度，而不应该是boolean。
 * @Author Garvey
 * @Date 2019-08-03 15:25
 */
public class IsBalanceBinaryTree55 {

    private boolean isBanlanced = true;

    public boolean isBalanced(TreeNode root) {
        treeDepth(root);
        return isBanlanced;
    }

    private int treeDepth(TreeNode node) {
        if (node == null || !isBanlanced) {
            // 已经确定不是平衡二叉树了，那么也就无需再计算深度
            return 0;
        }

        int left = treeDepth(node.left);
        int right = treeDepth(node.right);
        if (Math.abs(left - right) > 1) {
            isBanlanced = false;
        }

        return 1 + Math.max(left, right);
    }

}
