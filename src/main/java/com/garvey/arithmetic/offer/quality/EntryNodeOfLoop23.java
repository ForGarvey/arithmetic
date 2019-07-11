package com.garvey.arithmetic.offer.quality;

import com.garvey.arithmetic.offer.ListNode;

/**
 * @Description 23
 *  链表中环的入口节点：
 *      一个链表中包含环，请找出该链表的环的入口节点。
 *      1.链表是否包含环：
 *          ① 定义两个指针，同时从链表的头节点出发，一个指针一次走一步，另一个指针一次走两步。
 *          ② 如果走得快的指针追上了走得慢的指针，那么链表就包含环。
 *          ③ 如果走的快的指针走到了链表的末尾都没有追上第一个指针，那么链表就不包含环。
 *      2.找到环的入口：
 *          ① 先定义两个指针P1和P2指向链表的头节点。如果链表中的环有n个节点，则指针P1先在链表上向前移动n步，然后两个指针以相同的速度向前移动。
 *          ② 当第二个指针指向环的入口节点时，第一个指针已经围绕着环走了一圈，又回到了入口节点。（说明它们相遇的节点正好是环的入口节点）
 *      3.得到环中节点的数目：
 *          ① 如果两个一快一慢的指针相遇，则表明链表中存在环。
 *          ② 两个指针相遇的节点一定是在环中。可以从这个节点出发，一边继续向前移动一边计数，当再次回到这个节点时，就可以得到环中节点数了。
 * @Author Garvey
 * @Date 2019/7/11 11:30
 */
public class EntryNodeOfLoop23 {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        // 得到环中节点的数目
        int nodesInLoop = 1;
        ListNode nowNode = meetingNode;
        while (nowNode.next != meetingNode) {
            nowNode = nowNode.next;
            nodesInLoop++;
        }

        // 开始获取环入口节点
        // 先移动node1，次数为环中节点的数目
        ListNode node1 = pHead;
        for (int i = 0; i < nodesInLoop; ++i) {
            node1 = node1.next;
        }

        // 再移动node1和node2
        ListNode node2 = pHead;
        while (node2 != node1) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }

    /**
     * 寻找一快一慢两个指针相遇的节点
     * @param pHead
     * @return
     */
    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode slowNode = pHead.next;
        ListNode fastNode = slowNode.next;

        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
              return fastNode;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }
        return null;
    }
}
