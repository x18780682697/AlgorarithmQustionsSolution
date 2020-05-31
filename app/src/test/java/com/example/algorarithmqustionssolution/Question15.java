package com.example.algorarithmqustionssolution;

/**
 * 反转链表
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/15.html
 */
@SuppressWarnings("unused")
public class Question15 {

//    /**
//     * 链表节点类
//     */
//    public static class ListNode{
//        int val; // 结点的值
//        ListNode nxt; // 下一个结点
//    }

    private static ListNode reverseHead(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        head.next = null;
        head = pre;
        return head;
    }

}