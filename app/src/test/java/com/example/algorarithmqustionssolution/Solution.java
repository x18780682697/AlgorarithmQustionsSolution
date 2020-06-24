package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class Solution {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        String[] numStr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            numStr[i] = ""+numbers[i];
        }
        return printMinNumber(numStr);
    }

    /**
     * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * @param array 输入的数组
     * @return 输出结果
     */
    public static String printMinNumber(String[] array) {

        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("Array must contain value");
        }

        quickSort(array, 0, array.length - 1);

        StringBuilder builder = new StringBuilder();
        for (String s : array) {
            builder.append(s);
        }

        return builder.toString();
    }

    private static void quickSort(String[] array, int start, int end){
        // 单个区间仅剩1个元素时排序完成
        if (start < 0 || end >= array.length || start > end){
            return;
        }
        int left = start;
        int right = end;
        // 左右分区算法
        while (start < end){
            String pivot = array[start];
            while (start < end && customCompare(array[end], pivot) >= 0){
                end--;
            }
            array[start] = array[end];
            while (start < end && customCompare(array[start], pivot) <= 0){
                start++;
            }
            array[end] = array[start];
            array[start] = pivot;
        }
        // 递归排序左右分区
        quickSort(array, left, start-1);
        quickSort(array, start+1, right);
    }

    private static int customCompare(String num1, String num2){
        String num12 = num1+num2;
        String num21 = num2+num1;
        return num12.compareTo(num21);
    }

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public BinaryTreeNode parent;
        public TreeNode origin;
    }

}


/**
 * TreeNode和BinaryTreeNode之间的转换工具
 */
class NodeTranslateUtil {
    /**
     * 转换为TreeNode
     */
    public static TreeNode toTreeNode(Solution.BinaryTreeNode node){
        TreeNode treeNode = null;
        if (node == null){
            return null;
        }else{
            treeNode = new TreeNode(node.val);
            treeNode.left = toTreeNode(node.left);
            treeNode.right = toTreeNode(node.right);
            treeNode.next = toTreeNode(node.parent);
        }
        return treeNode;
    }

    /**
     * 转换为BinaryTreeNode
     */
    public static Solution.BinaryTreeNode toBinaryTreeNode(TreeNode node){
        Solution.BinaryTreeNode binaryTreeNode = null;
        if (node == null){
            return null;
        }else{
            binaryTreeNode = new Solution.BinaryTreeNode();
            binaryTreeNode.origin = node;
            binaryTreeNode.val = node.val;
            binaryTreeNode.left = toBinaryTreeNode(node.left);
            binaryTreeNode.right = toBinaryTreeNode(node.right);
            binaryTreeNode.parent = toBinaryTreeNode(node.next);
        }
        return binaryTreeNode;
    }
}

/**
 * 牛客网二叉树定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next = null;
    TreeNode(int x) { val = x; }
}