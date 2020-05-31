package com.example.algorarithmqustionssolution;

/**
 * 合并两个或k个有序链表
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/14.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question16 {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge2(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个链表为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 记录两个链表中头部较小的结点
        ListNode tmp = head1;
        if (tmp.val < head2.val) {
            // 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
            tmp.next = merge2(head1.next, head2);
        } else {
            // 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
            tmp = head2;
            tmp.next = merge2(head1, head2.next);
        }

        // 返回处理结果
        return tmp;
    }

}
