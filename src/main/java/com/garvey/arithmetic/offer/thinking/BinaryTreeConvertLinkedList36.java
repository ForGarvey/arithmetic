package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.TreeNode;

/**
 * @Description 36
 *  二叉搜索树与双向链表：
 *      输入一棵二叉搜索树，将该二叉搜索树转化成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *      1.在搜索二叉树中，左子节点的值总是小于父子节点的值，右子节点的值总是大于父子节点的值。
 *      2.因此，将二叉搜索树转换成排序双向链表时：
 *          原先指向左子节点的指针调整为链表中指向前一个节点的指针，原先指向右子节点的指针调整为链表中指向后一个节点的指针。
 *      3.由于要求转换之后的链表是排好序的，可以中序遍历树中的每个节点，这是因为中序遍历算法的特点是按照从小到大的顺序遍历二叉树的每个节点（对于二叉搜索树来说）。
 *      4.题目要求返回TreeNode，也就是说返回的根节点应该是原二叉搜索树的最小左子节点。
 * @Author Garvey
 * @Date 2019/7/18 16:02
 */
public class BinaryTreeConvertLinkedList36 {

    /**
     * 前一个节点
     */
    private TreeNode pre;

    /**
     * 返回转换后的根节点（原二叉搜索树的最小左子节点）
     */
    private TreeNode head;

    public TreeNode convert(TreeNode root) {
        convertNode(root);
        return head;
    }

    /**
     * 递归转换
     * @param node
     */
    private void convertNode(TreeNode node) {
        if (node == null) {
            return;
        }

        // 先链接左子树
        convertNode(node.left);

        node.left = pre;

        if (pre != null) {
            pre.right = node;
        }

        // 最左边的节点会先执行pre和head的赋值操作
        pre = node;

        if (head == null) {
            head = node;
        }

        // 再链接右子树
        convertNode(node.right);
    }
}
