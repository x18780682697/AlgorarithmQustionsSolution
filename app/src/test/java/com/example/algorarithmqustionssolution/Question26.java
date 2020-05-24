package com.example.algorarithmqustionssolution;

import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树与双向链表
 * (牛客网测试时，不可进行二叉树节点类型的转换，否则创建新节点后不能满足“不能创建任何新的节点”要求)
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/24.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question26 {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

    /**
     * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     * @param root 二叉树的根结点
     * @return 双向链表的头结点
     */
    public static BinaryTreeNode convert(BinaryTreeNode root) {

        // 用于保存处理过程中的双向链表的尾结点
        BinaryTreeNode[] lastNode = new BinaryTreeNode[1];
        convertNode(root, lastNode);

        // 找到双向链表的头结点
        BinaryTreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }


    /**
     * 链表表转换操作
     *
     * @param node     当前的根结点
     * @param lastNode 已经处理好的双向链表的尾结点，使用一个长度为1的数组，类似C++中的二级指针
     */
    public static void convertNode(BinaryTreeNode node, BinaryTreeNode[] lastNode) {
        // 结点不为空
        if (node != null) {

            // 如果有左子树就先处理左子树
            if (node.left != null) {
                convertNode(node.left, lastNode);
            }

            // 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
            node.left = lastNode[0];

            // 如果左子树转换成的双向链表不为空，设置尾结点的后继
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }

            // 记录当前结点为尾结点
            lastNode[0] = node;

            // 处理右子树
            if (node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }

}
