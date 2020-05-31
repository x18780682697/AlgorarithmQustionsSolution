package com.example.algorarithmqustionssolution.graph;

import java.util.Arrays;

/**
 * 图的邻接矩阵表存储方式
 */
@SuppressWarnings({"ForLoopReplaceableByForEach", "unused"})
public class AdjacencyListGraph {

    public Vertex[] vertexArray;
    public int[] visitedArray;

    public static AdjacencyListGraph create(int[] vertexArray, Edge[] edgeArray){
        AdjacencyListGraph graph = new AdjacencyListGraph();
        int vertexNum = vertexArray.length;
        graph.vertexArray = new Vertex[vertexNum];
        for (int i=0; i< vertexNum; i++){
            Vertex vertex = new Vertex();
            vertex.value = vertexArray[i];
            graph.vertexArray[i] = vertex;
        }
        graph.visitedArray = new int[vertexNum];
        graph.createAdjList(edgeArray);
        return graph;
    }

    private void createAdjList(Edge[] adj) {
        if (adj == null){
            return;
        }
        for (Edge edge: adj){
            Vertex vertex = new Vertex();
            vertex.value = edge.vertex2;
            Vertex start = vertexArray[getIndexByValue(edge.vertex1)];
            vertex.next = start.next;
            start.next = vertex;
        }
//        printAdj();
    }

    private void printAdj(){
        if (vertexArray == null){
            return;
        }
        for (int i=0; i<vertexArray.length; i++){
            Vertex currentVertex = vertexArray[i];
            while (currentVertex != null){
                System.out.print(currentVertex.value + " -> ");
                currentVertex = currentVertex.next;
            }
            System.out.print('\n');
        }
    }

    /**
     * 深度优先遍历
     */
    public void dfsFromFirstVertex(){
        Arrays.fill(visitedArray, 0);
        System.out.print("邻接表深度优先遍历\n");
        dfs(0);
        System.out.print('\n');
    }

    /**
     * 深度优先遍历
     */
    public void dfs(int v){
        Vertex currentVertex = vertexArray[v];
        System.out.print(currentVertex.value + " ");
        visitedArray[v] = 1;
        Vertex nextVertex = currentVertex.next;
        while (nextVertex != null){
            int index = getIndexByValue(nextVertex.value);
            if (visitedArray[index] == 0){
                dfs(index);
            }
            nextVertex = nextVertex.next;
        }
    }

    public int getIndexByValue(int value){
        int index = -1;
        for (int i=0; i<vertexArray.length; i++){
            if (vertexArray[i].value == value){
                index = i;
                break;
            }
        }
        return index;
    }

}
