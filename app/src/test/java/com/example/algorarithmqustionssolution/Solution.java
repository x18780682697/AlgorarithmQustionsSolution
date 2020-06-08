package com.example.algorarithmqustionssolution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("unused")
public class Solution {

    public int FirstNotRepeatingChar(String str) {
        if (str == null){
            return -1;
        }
        if (str.length() == 0){
            return -1;
        }
        char ch = firstNotRepeatingChar(str);
        return str.indexOf(ch);
    }

    public static char firstNotRepeatingChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch, -1);
            }else{
                map.put(ch, i);
            }
        }
        int firstNotRepeatIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            int index = entry.getValue();
            if (index >= 0 && index < firstNotRepeatIndex){
                firstNotRepeatIndex = index;
            }
        }
        return s.charAt(firstNotRepeatIndex);
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