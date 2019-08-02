package com.garvey.arithmetic.offer.efficiency;

import com.garvey.arithmetic.offer.ListNode;

/**
 * @Description 52
 *  两个链表的第一个公共节点：
 *      输入两个链表，找出它们的第一个公共节点。
 *      假设第一个链表的长度为m，第二个链表的长度为n。
 *      1.蛮力法：时间复杂度为O(mn)
 *          在第一链表上顺序遍历每个节点，每遍历到一个节点，就在第二个链表上顺序遍历每个节点。如果在第二个链表上有一个节点和
 *          第一个链表上的节点一样，则说明两个链表在这个节点上重合，于是就找到了它们的公共节点。
 *      2.从尾部开始查找：时间复杂度O(m+n)，空间复杂度O(m+n)
 *          ① 因为这两个链表是单向链表，所以从第一个公共节点开始，之后它们所有的节点都是重合的，不可能再出现分叉。所以我们
 *          可以从两个链表的尾部开始往前比较，最后一个相同的节点就是我们要找的节点。
 *          ② 由于链表是只能从头节点开始遍历，所以我们要从尾部开始查找，需要用到两个栈来分别存储两个链表的节点。
 *          ③ 分别把两个链表的节点放入两个栈里，然后比较两个栈顶的节点是否相同。如果相同则把栈顶弹出接着比较下一个栈顶，
 *          直到找到最后一个相同的节点即为它们的第一个公共节点。
 *      3.最优思路：时间复杂度O(m+n)，空间复杂度O(1)
 *          首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个节点。在第二次遍历的时候，
 *          在较长的链表上先走若干步，接着同时在两个链表上遍历，找到的第一个相同的节点就是它们的第一个公共节点。
 *      4.类似于第三种思路：时间复杂度O(m+n)，空间复杂度O(1)
 *          设链表 A 的长度为 a + c，链表 B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 *          当访问链表 A 的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 *          同样地，当访问链表 B 的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 *          这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。但是这种做法如果没有公共节点，程序会陷入死循环。
 * @Author Garvey
 * @Date 2019/8/2 11:38
 */
public class FindFirstCommonNode52 {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int length1 = getLinkedListLength(pHead1);
        int length2 = getLinkedListLength(pHead2);
        int diff = Math.abs(length1 - length2);

        ListNode longListNode;
        ListNode shortListNode;

        if (length1 >= length2) {
            longListNode = pHead1;
            shortListNode = pHead2;
        } else {
            longListNode = pHead2;
            shortListNode = pHead1;
        }

        for (int i = 0; i < diff; i++) {
            longListNode = longListNode.next;
        }

        while (longListNode != null && shortListNode != null && longListNode != shortListNode) {
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        return (longListNode == null || shortListNode == null) ? null : longListNode;
    }

    /**
     * 获取链表长度
     * @param node
     * @return
     */
    private int getLinkedListLength(ListNode node) {
        int length = 0;

        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

}
