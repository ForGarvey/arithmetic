package com.garvey.arithmetic.offer;

/**
 * @Description 08
 *  二叉树的下一个节点：
 *      给定一个二叉树和其中的一个节点，请找出中序遍历顺序的下一个节点并且返回。注意，树中的节点不仅包含左右子节点，同时包含指向父节点的指针。
 *      1.如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；否则，向上找第一个左链接指向的树包含该节点的祖先节点。
 * @Author Garvey
 * @Date 2019/5/21 15:21
 */
public class GetNextTreeNode08 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parentNode = pNode.next;
                if (parentNode.left == pNode) {
                    return parentNode;
                }
                pNode = parentNode;
            }
        }
        return null;
    }
}
