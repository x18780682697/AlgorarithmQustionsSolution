package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unused")
public class Solution {

    private static ArrayList<String> sResultList = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        sResultList.clear();
        permutation(str.toCharArray());
        sResultList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return sResultList;
    }

    /**
     * 题目：输入一个字符串，打印出该字符事中字符的所有排列。例如输入字符串abc。
     * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     *
     * @param chars 待排序的字符数组
     */
    public static void permutation(char[] chars) {
        // 输入较验
        if (chars == null || chars.length < 1) {
            return;
        }
        // 进行排列操作
        permutation(chars, 0);
    }

    /**
     * 求字符数组的排列
     *
     * @param chars 待排列的字符串
     * @param begin 当前处理的位置
     */
    public static void permutation(char[] chars, int begin) {
        // 如果是最后一个元素了，就输出排列结果
        if (chars.length - 1 == begin) {
            String result = new String(chars);
            System.out.println("result: " + result);
            if (!sResultList.contains(result)){
                sResultList.add(result);
                System.out.println(result + " ");
            }else{
                System.out.println("find repeat string: " + result);
            }
        } else {
            char tmp;
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int i = begin; i < chars.length; i++) {
                // 下面是交换元素的位置
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                // 处理下一个位置
                permutation(chars, begin + 1);

                chars[i] = chars[begin];
                chars[begin] = tmp;
            }
        }
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