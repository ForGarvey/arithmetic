package com.garvey.arithmetic.leetcode.easy;

import com.garvey.arithmetic.offer.ListNode;

/**
 * @Description 合并两个有序链表
 * @Author Garvey
 * @Date 2019-09-23 22:12
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode mergeNode = null;

        if (l1.val < l2.val) {
            mergeNode = l1;
            mergeNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeNode = l2;
            mergeNode.next = mergeTwoLists(l1, l2.next);
        }

        return mergeNode;
    }
}
