package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private int vertexCount;
    private LinkedList<Edge> [] list ;


    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.list = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int cost) {
        list[source].add(new Edge(source,destination,cost));
    }

    public void dfs(int source) {
        boolean[] visitedArray = new boolean[vertexCount];
        dfsRecursive(source, visitedArray);

    }
    private void dfsRecursive(int source, boolean[] visitedArray) {
        //visit node
        System.out.println(source);
        visitedArray[source] = true;

        //dfs all unvisited child nodes
        for(Edge edge: list[source]){
            if (!visitedArray[edge.destination]) dfsRecursive(edge.destination,visitedArray);
        }
    }

    public void bfs(int source) {
        boolean[] visited = new boolean[vertexCount];
        ArrayList<Integer> nodesToVisit = new ArrayList<>();
        nodesToVisit.add(source);
        bfsRecursive(nodesToVisit,visited);
    }

    private void bfsRecursive(ArrayList<Integer> nodesToVisit, boolean[] visited) {

        //if no node to visit, then return
        if (nodesToVisit.isEmpty()) return;

        //visit first node in the nodes to visit list and remove it from that list
        int node = nodesToVisit.removeFirst();
        visited[node] = true;
        System.out.println(node);

        //add all of its unvisited neighbours to nodes to visit list
        for (Edge neighbor: list[node]){
            if (!visited[neighbor.destination]) {
                nodesToVisit.add(neighbor.destination);
            }
        }
        bfsRecursive(nodesToVisit,visited);

    }

    public int[] dijkstra(int source) {
        boolean[] visited = new boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++) {visited[i] = false;}

        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {distance[i] = 1234567;}

        distance[source] = 0;
        dijkstraRecursive(source,distance,visited);
        return distance;

    }

    private boolean CanVisit(boolean[] visited){
        boolean cannotVisit = true;
        for (boolean isVisited: visited) {
            cannotVisit = cannotVisit && isVisited;
        }
        return !cannotVisit;
    }

    private void dijkstraRecursive(int source, int[] distance, boolean[] visited) {

        if (!CanVisit(visited)) return;

        //visit source
        visited[source] = true;
        System.out.println(source);

        //get list of neighbors
        LinkedList<Edge> adjList = list[source];
        for (Edge edge: adjList) {
            if (!visited[edge.destination]) {
                //update distance
                if (distance[edge.destination] > (distance[source] + edge.cost)) {
                    distance[edge.destination] = distance[source] + edge.cost;
                }
            }
        }
        //pic the unvisited node with minimum distance
        int minVertex = -1;
        int minDistance = -1;
        for (int i=0;i<vertexCount;i++) {
            if (!visited[i]) {
                if (minDistance == -1) {
                    minVertex = i;
                    minDistance = distance[i];
                }
                else {
                    if (distance[i] < minDistance) {
                        minVertex = i;
                        minDistance = distance[i];
                    }
                }
            }
        }

        dijkstraRecursive(minVertex,distance,visited);

    }

    public void print()
    {
        for (int i = 0; i < vertexCount; i++) {
            System.out.println(" ");
            System.out.print(i);
            System.out.print(" { ");
            for (int j=0;j<list[i].size();j++){
                System.out.print("( ");
                System.out.print(list[i].get(j).destination);
                System.out.print(",");
                System.out.print(list[i].get(j).cost);
                System.out.print(" ) ");
            }
            System.out.print(" } ");
        }
    }
}
