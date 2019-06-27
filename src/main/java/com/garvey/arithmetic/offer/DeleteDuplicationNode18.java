package com.garvey.arithmetic.offer;

/**
 * @Description 18.2
 *  在一个排序的链表中，删除链表中重复的结点
 * @Author Garvey
 * @Date 2019/6/17 16:50
 */
public class DeleteDuplicationNode18 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
