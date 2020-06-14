package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings("unused")
public class Solution {

    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null){
            return false;
        }
        return matchCore(new String(str), 0, new String(pattern), 0);
    }

    private static boolean matchCore(String input, int i, String pattern, int p) {

        // 递归边界条件设定

        // 模式字符串和而待匹配字符串均未达到末尾，匹配成功
        if (i >= input.length() && p >= pattern.length()){
            return true;
        }
        // 模式字符串已经达到末尾，而待匹配字符串未达到末尾，匹配失败
        if (p >= pattern.length() && i < input.length()) {
            return false;
        }

        // 下一个字符为*则需要进行特殊匹配
        if (p+1 < pattern.length() && pattern.charAt(p+1) == '*'){
            // 根据当前模式字符和待匹配字符是否一致，进行后续匹配
            if ((pattern.charAt(p) == '.' && i < input.length())
                    || (i < input.length() && pattern.charAt(p) == input.charAt(i))){
                return matchCore(input, i, pattern, p+2) /*x*匹配0个*/
                        || matchCore(input, i+1, pattern, p+2) /*x*匹配1个*/
                        || matchCore(input, i+1, pattern, p); /*x*匹配多个*/
            }else{
                return matchCore(input, i, pattern, p+2) /*x*匹配0个*/;
            }
        }else{
            if ((pattern.charAt(p) == '.' && i < input.length())
                    || (i < input.length() && pattern.charAt(p) == input.charAt(i))){
                return matchCore(input, i+1, pattern, p+1);
            }else{
                return false;
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