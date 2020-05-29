package com.example.algorarithmqustionssolution;

import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;

/**
 * 二叉树的下一个结点
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/56.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question57 {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        // 保存要查找的下一个节点
        BinaryTreeNode target = null;

        if (node.right != null) {
            target = node.right;
            while (target.left != null) {
                target = target.left;
            }

            return target;
        } else if (node.parent != null){
            target = node.parent;
            BinaryTreeNode cur = node;
            // 如果父新结点不为空，并且，子结点不是父结点的左孩子
            while (target != null && target.left != cur) {
                cur = target;
                target = target.parent;

            }

            return target;
        }

        return null;
    }

}
