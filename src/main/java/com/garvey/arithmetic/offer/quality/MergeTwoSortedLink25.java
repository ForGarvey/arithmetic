package com.garvey.arithmetic.offer.quality;

import com.garvey.arithmetic.offer.ListNode;

/**
 * @Description 25
 *  合并两个排序的链表：
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *      1.当我们得到两个链表中值较小的头节点，并把它链接到已经合并的链表之后，两个链表剩余的节点依然是排序的。
 *      2.因此合并的步骤和之前的步骤是一样的。这就是典型的递归过程。
 *      3.注意代码鲁棒性（健壮性）：
 *          ① 当第一个链表是空链表，也就是它的头节点是一个空指针时，那么把它和第二个链表合并，显然合并的结果就是第二个链表。
 *          ② 同样，当输入的第二个链表的头节点是空指针的时候，我们把它和第一个链表合并得到的结果就是第一个链表。
 *          ③ 如果两个链表都是空链表，则合并的结果是得到一个空链表。
 * @Author Garvey
 * @Date 2019/7/11 16:21
 */
public class MergeTwoSortedLink25 {

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode mergeNode = null;

        if (list1.val < list2.val) {
            mergeNode = list1;
            mergeNode.next = merge(list1.next, list2);
        } else {
            mergeNode = list2;
            mergeNode.next = merge(list1, list2.next);
        }

        return mergeNode;
    }

}
