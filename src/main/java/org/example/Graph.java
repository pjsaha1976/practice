package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private int vertexCount;
    private LinkedList<Integer> [] list ;


    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        this.list = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        list[source].add(destination);
    }

    public void dfs(int source) {
        boolean[] visitedArray = new boolean[vertexCount];
        dfsRecursive(source, visitedArray);

    }
    private void dfsRecursive(int source, boolean[] visitedArray) {
        //vist node
        System.out.println(source);
        visitedArray[source] = true;

        //dfs all unvisited child nodes
        for(int node: list[source]){
            if (!visitedArray[node]) dfsRecursive(node,visitedArray);
        }
    }

    public void bfs(int source) {
        boolean[] visited = new boolean[vertexCount];
        ArrayList<Integer> nodesToVisit = new ArrayList<Integer>();
        nodesToVisit.add(source);
        bfsRecurrsive(nodesToVisit,visited);
    }

    private void bfsRecurrsive(ArrayList<Integer> nodesToVisit, boolean[] visited) {

        //if no node to visit, then return
        if (nodesToVisit.isEmpty()) return;

        //visit first node in the nodes to visit list and remove it from that list
        int node = nodesToVisit.removeFirst();
        visited[node] = true;
        System.out.println(node);

        //add all of its unvisited neighbours to nodes to visit list
        for (int neighbor: list[node]){
            if (!visited[neighbor]) {
                nodesToVisit.add(neighbor);
            }
        }
        bfsRecurrsive(nodesToVisit,visited);

    }

    public void print()
    {
        for (int i = 0; i < vertexCount; i++) {
            System.out.println(" ");
            System.out.print(i);
            System.out.print(" { ");
            for (int j=0;j<list[i].size();j++){
                System.out.print(list[i].get(j));
                System.out.print(" ");
            }
            System.out.print(" } ");
        }
    }
}
