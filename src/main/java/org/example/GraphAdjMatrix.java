package org.example;

import java.util.ArrayList;

public class GraphAdjMatrix {
    private int vertexCount;
    private int[][] adjMatrix;

    public GraphAdjMatrix(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new int[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                adjMatrix[i][j] = 11111; //infinity
                if (i == j) {adjMatrix[i][j] = 0;}
            }
        }
    }

    //add edge
    public void addEdge(int source, int destination, int cost) {
        adjMatrix[source][destination] = cost;
    }

    public void bfs(int source) {
        boolean[] visited = new boolean[vertexCount];
        ArrayList<Integer> nodesToVisit = new ArrayList<>();
        nodesToVisit.add(source);
        bfsRecursion(nodesToVisit,visited);
    }

    private void bfsRecursion(ArrayList<Integer> nodesToVisit, boolean[] visited ){

        if (nodesToVisit.isEmpty()) return;

        //visit the first node in the list
        int node = nodesToVisit.removeFirst();
        if (!visited[node]) {
            //visit node
            visited[node] = true;
            System.out.println(node);
            //add all unvisited neighbors of node to the nodesToVisit list
            for (int i = 0; i < adjMatrix[node].length; i++) {
                if (adjMatrix[node][i] != 11111) { //its a neighbor
                    if (!visited[i]) nodesToVisit.add(i);
                }
            }
        }
        //bfs recursion
        bfsRecursion(nodesToVisit,visited);
    }

    public void dfs(int source) {
        boolean[] visited = new boolean[vertexCount];
        dfsRecursion(source,visited);
    }

    private void dfsRecursion(int node, boolean[] visited) {
        //visit node
        if (!visited[node]){
            visited[node] = true;
            System.out.println(node);
            for (int i = 0; i < adjMatrix[node].length; i++) {
                if (adjMatrix[node][i] != 11111) {//neighbor
                    if (!visited[i]) dfsRecursion(i, visited);
                }
            }
        }
    }

    public int[] dijkstra(int source) {
        //array to track distance from source to all nodes in the graph
        int[] distance = new int[vertexCount];
        for (int i=0; i<vertexCount;i++){
            distance[i] = 11111;
        }
        // aray to track visited nodes
        boolean[] visited = new boolean[vertexCount];
        for (int i=0; i<vertexCount;i++){
            visited[i] = false;
        }

        distance[source] = 0;
        dijkstraRecursive(source,distance,visited);
        return distance;
    }

    private void dijkstraRecursive(int source, int[] distance, boolean[] visited) {

        if (allNodesVisited(visited)) return;

        //visit source
        System.out.println(source);
        visited[source] = true;

        //find unvisited neighbours and update distance array for each neighbor
        for (int i=0; i<vertexCount;i++){
            if (adjMatrix[source][i] < 11111) //neighbor
            {
                if (!visited[i]) {
                    if (distance[i] > (distance[source] + adjMatrix[source][i]))
                    {
                        distance[i] = distance[source] + adjMatrix[source][i];
                    }
                }
            }
        }

        //find the unvisited vertex with minimum distance value
        int minDistance = Integer.MIN_VALUE;
        int minVertex = -1;
        for (int i=0;i<vertexCount;i++)
        {
            if (!visited[i]) {
                if(minDistance == Integer.MIN_VALUE) {
                    minDistance = distance[i];
                    minVertex = i;
                }
                else {
                    if (distance[i] < minDistance) {
                        minDistance = distance[i];
                        minVertex = i;
                    }

                }
            }

        }

        dijkstraRecursive(minVertex,distance,visited);


    }

    private boolean allNodesVisited(boolean[] visited) {
        for (int i=0; i<vertexCount;i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    public int[][] allPairShortestPath(){
        //initialize result array
        int[][] result = this.adjMatrix;

        for (int k=0;k<vertexCount;k++)
        {
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    result[i][j] = Integer.min(result[i][j], (result[i][k] + result[k][j]));
                }
            }
        }
        return result;
    }

    //print graph
    public void print(){
        for(int i = 0; i<vertexCount; i++){
            System.out.print("node " + i + " : ");
            for(int j = 0; j<vertexCount; j++){
                if (adjMatrix[i][j] != 11111){
                    System.out.print("{" + i + "->" + j + ", " +  adjMatrix[i][j] + " }");
                }
            }
            System.out.println();
        }
    }
}
