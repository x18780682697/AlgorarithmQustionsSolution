package com.example.algorarithmqustionssolution;


import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;

/**
 * 根据前序遍历和中序遍历重建二叉树
 * （此解法有缺陷，在牛客网仅有70%的通过率）
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/04.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
public class Question18 {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

    /**
     * 请完成一个函数，输入…个二叉树，该函数输出它的镜像
     *
     * @param node 二叉树的根结点
     */
    public static void mirror(BinaryTreeNode node) {
        // 如果当前结点不为空则进行操作
        if (node != null) {
            // 下面是交换结点左右两个子树
            BinaryTreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            // 对结点的左右两个子树进行处理
            mirror(node.left);
            mirror(node.right);
        }
    }

}
