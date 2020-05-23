@file:Suppress("MemberVisibilityCanBePrivate")

package com.example.algorarithmqustionssolution.binarytree


import com.example.algorarithmqustionssolution.Solution.*

object BinaryTreeUtil {

    fun createByPreOrderArray(array: Array<Int?>, iterator: Iterator<Int?>): BinaryTreeNode?{
        var currentValue: Int? = null
        if (iterator.hasNext()){
            currentValue = iterator.next()
        }
        return if(currentValue == null){
            null
        }else{
            BinaryTreeNode().apply {
                value = currentValue
                left = createByPreOrderArray(array, iterator)
                right = createByPreOrderArray(array, iterator)
            }
        }
    }

    /**
     * 前序遍历
     */
    fun preOrderTraversal(rootNode: BinaryTreeNode?){
        rootNode?.run {
            print("${rootNode.value},")
            preOrderTraversal(rootNode.left)
            preOrderTraversal(rootNode.right)
        }
    }

    /**
     * 中序遍历
     */
    fun inOrderTraversal(rootNode: BinaryTreeNode?){
        rootNode?.run {
            inOrderTraversal(rootNode.left)
            print("${rootNode.value},")
            inOrderTraversal(rootNode.right)
        }
    }

    /**
     * 后序遍历
     */
    fun postOrderTraversal(rootNode: BinaryTreeNode?, resultList: ArrayList<Int>? = null): ArrayList<Int>? {
        rootNode?.run {
            postOrderTraversal(rootNode.left, resultList)
            postOrderTraversal(rootNode.right, resultList)
            rootNode.value.apply {
                print("$this,")
            }.apply {
                resultList?.add(this)
            }
        }
        return resultList
    }

}