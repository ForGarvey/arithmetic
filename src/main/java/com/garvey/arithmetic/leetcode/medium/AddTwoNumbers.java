package com.garvey.arithmetic.leetcode.medium;

import com.garvey.arithmetic.offer.ListNode;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Optional;

/**
 * @Description 两数相加
 * @Author Garvey
 * @Date 2020/1/14 14:37
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = null;
        ListNode sumCurNode = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;
        while (cur1 != null || cur2 != null || carry != 0) {
            int curVal1 = cur1 == null ? 0 : cur1.val;
            int curVal2 = cur2 == null ? 0 : cur2.val;
            int sum = curVal1 + curVal2 + carry;
            carry = sum / 10;
            if (sumNode == null) {
                sumNode = new ListNode(sum % 10);
                sumCurNode = sumNode;
            } else {
                sumCurNode.next = new ListNode(sum % 10);
                sumCurNode = sumCurNode.next;
            }

            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        return sumNode;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode sumNode = addTwoNumbers.addTwoNumbers(l1, l2);
        while (sumNode != null) {
            System.out.println(sumNode.val);
            sumNode = sumNode.next;
        }
    }

}
