package com.example.algorarithmqustionssolution;

import com.example.algorarithmqustionssolution.Solution.*;

import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/03.html
 */
@SuppressWarnings("unused")
public class Question3 {

/*    *//**
     * 链表节点类
     *//*
    public static class ListNode{
        int val; // 结点的值
        ListNode nxt; // 下一个结点
    }*/

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用递归的方式进行
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingRecursion(ListNode root) {
        if (root != null) {
            printListInverselyUsingRecursion(root.next);
            System.out.print(root.val + " ");
        }
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值
     * 使用栈的方式进行
     *
     * @param root 链表头结点
     */
    public static void printListInverselyUsingIteration(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }

}
