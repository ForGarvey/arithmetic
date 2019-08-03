package com.garvey.arithmetic.offer.ability;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 54
 *  二叉搜索树的第k大节点：
 *      给定一棵二叉搜索树，请找出其中第k大的节点。
 *      1.如果按照中序遍历的顺序遍历一棵二叉搜索树，则遍历序列的数值是递增排序的。
 * @Author Garvey
 * @Date 2019-08-03 11:21
 */
public class KthNodeOfBinaryTree54 {

    private int count;

    public TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        return kthNodeCore(pRoot, k);
    }

    private TreeNode kthNodeCore(TreeNode node, int k) {

        TreeNode targetNode = null;

        if (node.left != null) {
            targetNode = kthNodeCore(node.left, k);
        }

        if (targetNode == null) {
            count++;
            if (count == k) {
                targetNode = node;
            }
        }

        if (targetNode == null && node.right != null) {
            targetNode = kthNodeCore(node.right, k);
        }

        return targetNode;
    }

    public static void main(String[] args) {
        TreeNode pNode = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(8);

        pNode.left = node1;
        pNode.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        node4.right = node6;




        KthNodeOfBinaryTree54 kthNodeOfBinaryTree54 = new KthNodeOfBinaryTree54();
        System.out.println(kthNodeOfBinaryTree54.kthNode(pNode, 3).val);
    }
}
