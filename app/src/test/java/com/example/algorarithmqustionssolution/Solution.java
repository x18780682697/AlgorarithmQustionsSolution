package com.example.algorarithmqustionssolution;

/**
 * 牛客网二叉树定义
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    /**
     * 二叉树节点类
     */
    public static class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

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

    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return BinaryTreeNode.toTreeNode(construct(pre, 0, pre.length - 1, in, 0, in.length - 1));
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 前序遍历
     * @param ps       前序遍历的开始位置
     * @param pe       前序遍历的结束位置
     * @param inorder  中序遍历
     * @param is       中序遍历的开始位置
     * @param ie       中序遍历的结束位置
     * @return 树的根结点
     */
    public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe/*注意边界条件，ps与pe值相等*/){
            return null;
        }
        int rootNodeValue = preorder[ps];
        int inOrderIndex = is;
        for(int index = is; index <= ie/*注意边界条件，index可取得ie值*/; index++){
            if (inorder[index] == rootNodeValue){
                inOrderIndex = index;
            }
        }
        BinaryTreeNode node = new BinaryTreeNode();
        node.value = rootNodeValue;
        node.left = construct(preorder, ps+1, ps+1+inOrderIndex-1-is,
                inorder, is, inOrderIndex-1);
        node.right = construct(preorder, ps+1+inOrderIndex-1-is+1, pe,
                inorder, inOrderIndex+1, ie);
        return node;
    }

}
