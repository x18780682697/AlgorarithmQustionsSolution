package com.example.algorarithmqustionssolution;

import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;

/**
 * 二叉树的深度
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/36.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question38 {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

    public static int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? (left + 1) : (right + 1);
    }

}
