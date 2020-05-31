package com.example.algorarithmqustionssolution.graph

/**
 * 示例图链接：https://blog.csdn.net/qq_22238021/article/details/78286798
 * （链接中邻接表的图片说明有误，需要参考链接中的代码进行修正）
 */
object ExampleGraph{

    /**
     * 顶点数组
     */
    private val vertexArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)

    /**
     * 边数组，用于转换为邻接矩阵或者是邻接表
     */
    private val edgeArray = arrayOf(
        /*Edge(0,1),*/ Edge(0, 2), Edge(0,1),
        /*Edge(1, 3),*/ Edge(1, 4), Edge(1, 3),
        /*Edge(2, 5),*/ Edge(2, 6), /*Edge(2, 6),*/ Edge(2, 5),
        Edge(5, 6),
        Edge(3, 7),
        Edge(4, 7),
//        Edge(5, 6),
        Edge(7, 8)
    )

    fun createAdjMatrix(): AdjacencyMatrixGraph?{
        return AdjacencyMatrixGraph.create(vertexArray, edgeArray)
    }

    fun createAdjList(): AdjacencyListGraph?{
        return AdjacencyListGraph.create(vertexArray, edgeArray)
    }

}