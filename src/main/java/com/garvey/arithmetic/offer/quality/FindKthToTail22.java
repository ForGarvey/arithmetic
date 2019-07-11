package com.garvey.arithmetic.offer.quality;

import com.garvey.arithmetic.offer.ListNode;

import java.util.List;

/**
 * @Description 22
 *  链表中倒数第k个结点：
 *      输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *      1.假设整个链表有n个节点，那么倒数第k个节点就是从头节点开始的第n-k+1个节点。如果我们能够得到链表中节点的个数n，那么只要从头节点开始往后走n-k+1步就可以了。
 *      2.为了实现只遍历链表一次就能找到倒数第k个节点，我们可以定义两个指针。第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动；
 *        从第k步开始，第二个指针也开始从链表的头指针开始遍历。由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾节点时，第二个（走在后面的）指针正好指向倒数第k个节点。
 *      3.注意代码鲁棒性（健壮性）：
 *          ① 输入的head为空指针。由于代码会试图访问空指针指向的内存，从而造成程序崩溃。
 *          ② 输入的以head为头节点的链表的节点总数少于k。由于在for循环中会在链表上向前走k-1步，仍然会由于空指针而造成程序崩溃。
 *          ③ 输入的参数k为0。由于k是一个无符号数，那么在for循环中k-1得到的将不是-1，而是4294967295（无符号的0xFFFFFFFF）。因此，for循环执行的次数远远超出我们的预计，同样也会造成程序崩溃。
 * @Author Garvey
 * @Date 2019/7/10 19:06
 */
public class FindKthToTail22 {

    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode nodeOne = head;
        ListNode nodeTwo = head;

        for (int i = 0; i < k - 1; i++) {
            if (nodeOne.next != null) {
                nodeOne = nodeOne.next;
            } else {
                return null;
            }
        }

        while (nodeOne.next != null) {
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next;
        }
        return nodeTwo;
    }

}
