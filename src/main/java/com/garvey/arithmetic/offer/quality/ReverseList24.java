package com.garvey.arithmetic.offer.quality;

import com.garvey.arithmetic.offer.ListNode;

/**
 * @Description 24
 *  反转链表：
 *      定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *      1.比如h、i、j是原链表中连续的三个节点。
 *          ① 当我们遍历到节点i要进行反转时，除了需要知道节点i本身，还需要知道i的前一个节点h，
 *          因为我们需要把节点i的next指向h。
 *          ② 同时，我们还需要事先保存i的下一个节点j，以防止链表断开。
 *      2.所以我们需要定义三个指针，分别指向当前遍历到的节点、它的前一个节点及后一个节点。
 *      3.注意代码鲁棒性（健壮性）：
 *          ① 输入的链表头指针为null或者整个链表只有一个节点时，程序立即崩溃。
 *          ② 反转后的链表出现断裂。
 *          ③ 返回的反转之后的头节点不是原始链表的尾节点。
 * @Author Garvey
 * @Date 2019/7/11 15:04
 */
public class ReverseList24 {

    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode nowNode = head;
        ListNode preNode = null;

        while (nowNode != null) {
            ListNode nextNode = nowNode.next;
            // 说明遍历到原链表的尾节点
            if (nextNode == null) {
                reversedHead = nowNode;
            }

            // 反转
            nowNode.next = preNode;

            preNode = nowNode;
            nowNode = nextNode;
        }

        return reversedHead;
    }
}
