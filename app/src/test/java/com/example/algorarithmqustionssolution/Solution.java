package com.example.algorarithmqustionssolution;

@SuppressWarnings("unused")
public class Solution {

    /**
     * 寻找相同节点并比较结构是否相同
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // root2为空不认为是子结构
        if(root2==null) return false;
        // root1为空不认为是子结构
        if(root1==null && root2!=null) return false;
        boolean flag = false;
        // 判定当前根节点是否与root2根节点相同
        if(root1.val==root2.val){
            // 若当前根节点相同，比较节点之下的结构是否相同
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            // 递归寻找左子树上是否有与root2相同的子结构
            flag = HasSubtree(root1.left, root2);
            if(!flag){
                // 如左子树上未找到，则递归寻找右子树上是否有与root2相同的子结构
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        // 已经比较完全，判定root2是root1的子结构
        if(root2==null) return true;
        // root2深度大于root1，则判定root2不是root1的子结构
        if(root1==null && root2!=null) return false;
        // 根节点值相同，并且左右子树上的节点值也完全相同
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
            return false;
        }
    }

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    /**
     * TreeNode和BinaryTreeNode之间的转换工具
     */
    public static class NodeTranslateUtil {
        /**
         * 转换为TreeNode
         */
        public static TreeNode toTreeNode(BinaryTreeNode node){
            TreeNode treeNode = null;
            if (node == null){
                return null;
            }else{
                treeNode = new TreeNode(node.value);
                treeNode.left = toTreeNode(node.left);
                treeNode.right = toTreeNode(node.right);
            }
            return treeNode;
        }

        /**
         * 转换为BinaryTreeNode
         */
        public static BinaryTreeNode toBinaryTreeNode(TreeNode node){
            BinaryTreeNode binaryTreeNode = null;
            if (node == null){
                return null;
            }else{
                binaryTreeNode = new BinaryTreeNode();
                binaryTreeNode.value = node.val;
                binaryTreeNode.left = toBinaryTreeNode(node.left);
                binaryTreeNode.right = toBinaryTreeNode(node.right);
            }
            return binaryTreeNode;
        }
    }

}

/**
 * 牛客网二叉树定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}