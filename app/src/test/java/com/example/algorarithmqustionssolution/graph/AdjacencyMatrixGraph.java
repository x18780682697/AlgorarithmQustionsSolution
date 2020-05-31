package com.example.algorarithmqustionssolution.graph;

import java.util.Arrays;

/**
 * 图的邻接矩阵存储方式
 */
@SuppressWarnings({"ForLoopReplaceableByForEach", "unused"})
public class AdjacencyMatrixGraph {

    public int[] vertexArray;
    public int[][] adj;
    public int [] visitedArray;

    public static AdjacencyMatrixGraph create(int[] vertexArray, Edge[] edgeArray){
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph();
        graph.vertexArray = vertexArray;
        int vertexNum = graph.vertexArray.length;
        graph.visitedArray = new int[vertexNum];
        graph.adj = new int[vertexNum][vertexNum];
        graph.createAdjMatrix(edgeArray);
        return graph;
    }

    private void createAdjMatrix(Edge[] adj) {
        if (adj == null){
            return;
        }
        for (Edge edge: adj){
            this.adj[edge.vertex1][edge.vertex2] = 1;
            this.adj[edge.vertex2][edge.vertex1] = 1;
        }
//        printAdj();
    }

    private void printAdj(){
        if (adj == null){
            return;
        }
        for (int i=0; i<adj.length; i++){
            for (int j=0; j< adj.length; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    /**
     * 深度优先遍历
     */
    public void dfsFromFirstVertex(){
        Arrays.fill(visitedArray, 0);
        System.out.print("邻接矩阵深度优先遍历\n");
        dfs(0);
        System.out.print("\n");
    }

    /**
     * 深度优先遍历
     */
    public void dfs(int v){
        if (visitedArray[v] == 1){
            return;
        }
        System.out.print(vertexArray[v] + " ");
        visitedArray[v] = 1;
        for (int i=0; i<vertexArray.length; i++){
            if (adj[v][i] == 1 && visitedArray[i] == 0){
                dfs(i);
            }
        }
    }

}
