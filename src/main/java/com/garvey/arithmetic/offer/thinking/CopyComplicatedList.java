package com.garvey.arithmetic.offer.thinking;

import com.garvey.arithmetic.offer.RandomListNode;

/**
 * @Description 35
 *  复杂链表的复制：
 *      输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的 head。
 *      1.在每个节点的后面插入复制的节点：
 *          复制原始链表的任意节点N并创建新节点N'，再把N'链接到N的后面。
 *      2.对复制节点的random链接进行赋值：
 *          如果原始链表上的节点N的random链接指向S，则它对应的复制节点N'的random链接指向S的复制节点S'。
 *      3.把这个长链表拆分成两个链表：
 *          把奇数位置的节点用next链接起来的就是原始链表，把偶数位置的节点用next链接起来的就是复制出来的链表。
 *          即奇数位置上的节点组成原始链表，偶数位置上的节点组成复制出来的链表。
 * @Author Garvey
 * @Date 2019/7/18 11:49
 */
public class CopyComplicatedList {

    public RandomListNode clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        // 1.在每个节点的后面插入复制的节点
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode cloneNode = new RandomListNode(node.label);

            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }

        // 2.对复制节点的random链接进行赋值
        node = pHead;
        while (node != null) {
            RandomListNode cloneNode = node.next;
            if (node.random != null) {
                cloneNode.random = node.random.next;
            }
            node = cloneNode.next;
        }

        // 3.把这个长链表拆分成两个链表
        RandomListNode cloneHead = pHead.next;
        RandomListNode cloneNode = cloneHead;
        node = pHead;

        // 在循环外进行第一步拆分，可以防止由于只有pHead一个节点导致的空指针异常。也就是这里的cloneNext.next为null
        node.next = cloneNode.next;
        node = node.next;

        // 如果只有pHead一个节点，那么此时node为null，也就不会进入循环导致空指针异常了。
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;

            node.next = cloneNode.next;
            node = node.next;
        }

        return cloneHead;
    }
}
