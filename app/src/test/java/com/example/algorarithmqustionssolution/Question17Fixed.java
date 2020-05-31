package com.example.algorarithmqustionssolution;


import com.example.algorarithmqustionssolution.Solution.BinaryTreeNode;

/**
 * 根据前序遍历和中序遍历重建二叉树
 * （此解法为牛客网的修复版本）
 *
 * 网页链接：https://lrh1993.gitbooks.io/android_interview_guide/content/algorithm/For-offer/04.html
 */
public class Question17Fixed {

//    /**
//     * 二叉树节点类
//     */
//    public static class BinaryTreeNode {
//        int value;
//        BinaryTreeNode left;
//        BinaryTreeNode right;
//    }

//    public static boolean HasSubtree(BinaryTreeNode root1,BinaryTreeNode root2) {
//        if(root2==null) return false;
//        if(root1==null && root2!=null) return false;
//        boolean flag = false;
//        if(root1.value==root2.value){
//            flag = isSubTree(root1,root2);
//        }
//        if(!flag){
//            flag = HasSubtree(root1.left, root2);
//            if(!flag){
//                flag = HasSubtree(root1.right, root2);
//            }
//        }
//        return flag;
//    }

//    private static boolean isSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
//        if(root2==null) return true;
//        if(root1==null && root2!=null) return false;
//        if(root1.value==root2.value){
//            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
//        }else{
//            return false;
//        }
//    }

}
