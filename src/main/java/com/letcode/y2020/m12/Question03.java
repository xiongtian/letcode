package com.letcode.y2020.m12;

/**
 * @Author xiongtian
 * @Date 2020/12/8 17:41
 * @Version 1.0
 * <p>
 * <p>
 * 问题：合并两个有序链表
 */

public class Question03 {

    public static void main(String[] args) {
        Question03 resolve = new Question03();
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(8);

        node5.next = node6;

        ListNode node7 = node5;

        ListNode listNode = resolve.mergeTwoLists(node1, node7);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /*
     * l1:3,5,7,9
     * l2:4,8
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
