package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    public int FirstNotRepeatingChar(String str) {
        // 结果默认为-1（表示未找到）
        int result = -1;
        if (str != null && str.length() > 0){
            char ch = firstNotRepeatingChar(str);
            result = str.indexOf(ch);
        }
        return result;
    }

    public static char firstNotRepeatingChar(String s) {
        if (s == null || s.length() < 1) {
            throw new IllegalArgumentException("Arg should not be null or empty");
        }

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -2);
            } else {
                map.put(c, i);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        // 记录只出现一次的字符的索引
        int idx = Integer.MAX_VALUE;
        // 记录只出现一次的字符
        char result = '\0';

        // 找最小索引对应的字符
        for (Map.Entry<Character, Integer> entry : entrySet) {
            if (entry.getValue() >= 0 && entry.getValue() < idx) {
                idx = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
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