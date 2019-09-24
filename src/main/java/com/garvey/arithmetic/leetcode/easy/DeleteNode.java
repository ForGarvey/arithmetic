package com.garvey.arithmetic.leetcode.easy;

import com.garvey.arithmetic.offer.ListNode;

/**
 * @Description 删除链表中的节点
 * @Author Garvey
 * @Date 2019-09-24 23:20
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if (node != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

}
