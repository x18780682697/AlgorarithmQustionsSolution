package com.example.algorarithmqustionssolution;

import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 按之字形顺序打印二叉树
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/59.html
 * 题号链接：https://zhuanlan.zhihu.com/p/56200260
 */
@SuppressWarnings("unused")
public class Question59 {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

    public static void print(BinaryTreeNode root) {

        if (root == null) {
            return;
        }


        List<BinaryTreeNode> current = new LinkedList<>();
        List<BinaryTreeNode> reverse = new LinkedList<>();
        int flag = 0;
        BinaryTreeNode node;
        current.add(root);

        while (current.size() > 0) {

            // 从最后一个开始取
            node = current.remove(current.size() - 1);

            System.out.printf("%-3d", node.val);

            // 当前是从左往右打印的，那就按从左往右入栈
            if (flag == 0) {
                if (node.left != null) {
                    reverse.add(node.left);
                }

                if (node.right != null) {
                    reverse.add(node.right);
                }


            }
            // 当前是从右往左打印的，那就按从右往左入栈
            else {
                if (node.right != null) {
                    reverse.add(node.right);
                }

                if (node.left != null) {
                    reverse.add(node.left);
                }
            }

            if (current.size() == 0) {
                flag = 1 - flag;
                List<BinaryTreeNode> tmp = current;
                current = reverse;
                reverse = tmp;
                System.out.println();
            }
        }
    }

}
