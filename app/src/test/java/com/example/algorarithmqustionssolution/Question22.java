package com.example.algorarithmqustionssolution;

import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/20.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question22 {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

    /**
     * 从上往下打印出二叉树的每个结点，向一层的结点按照从左往右的顺序打印。
     * 例如下的二叉树，
     *       8
     *    /    \
     *   6     10
     *  /  \   / \
     * 5   7  9  11
     * 则依次打印出8、6、10、5、3 、9、11.
     *
     * @param root 树的结点
     */
//    public static void printFromToBottom(BinaryTreeNode root) {
//
//        // 当结点非空时才进行操作
//        if (root != null) {
//            // 用于存放还未遍历的元素
//            Queue<BinaryTreeNode> list = new LinkedList<>();
//            // 将根结点入队
//            list.add(root);
//            // 用于记录当前处理的结点
//            BinaryTreeNode curNode;
//
//            // 队列非空则进行处理
//            while (!list.isEmpty()) {
//                // 删除队首元素
//                curNode = list.remove();
//                // 输出队首元素的值
//                System.out.print(curNode.value + " ");
//                // 如果左子结点不为空，则左子结点入队
//                if (curNode.left != null) {
//                    list.add(curNode.left);
//                }
//                // 如果右子结点不为空，则左子结点入队
//                if (curNode.right != null) {
//                    list.add(curNode.right);
//                }
//            }
//        }
//    }

}
