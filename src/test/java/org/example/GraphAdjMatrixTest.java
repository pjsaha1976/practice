package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphAdjMatrixTest {

    @Test
    void addEdge()
    {
        //given
        GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0,1, 6);
        g.addEdge(0,2, 7);
        g.addEdge(0,3, 1);
        g.addEdge(2,1, 5);
        g.addEdge(1,3, 2);

        //when
        g.print();

        //then
    }

    @Test
    void bfsRecursion()
    {
        //given
        GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0,1, 6);
        g.addEdge(0,2, 7);
        g.addEdge(0,3, 1);
        g.addEdge(2,1, 5);
        g.addEdge(1,3, 2);

        //when
        g.bfs(0);

        //then

    }

    @Test
    void dfs()
    {
        //given
        GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0,1, 6);
        g.addEdge(0,2, 7);
        g.addEdge(0,3, 1);
        g.addEdge(2,1, 5);
        g.addEdge(1,3, 2);

        //when
        g.dfs(0);

        //then
    }

    @Test
    void dijkstra(){
        //given
        GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0,1, 6);
        g.addEdge(0,2, 7);
        g.addEdge(0,3, 11);
        g.addEdge(2,1, 5);
        g.addEdge(1,3, 2);

        //when
        int[] result = g.dijkstra(0);

        //then
        assertArrayEquals(new int[]{0,6,7,8}, result);
    }

    @Test
    void allPairShortestPath(){

        //given
        GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0,1, 3);
        g.addEdge(0,3, 7);

        g.addEdge(1,0, 8);
        g.addEdge(1,2, 2);

        g.addEdge(2,0, 5);
        g.addEdge(2,3, 1);

        g.addEdge(3,0, 2);

        //when
        int[][] result = g.allPairShortestPath();

        //then
        for (int[] row : result) {
            System.out.println();
            for (int i : row) {
                System.out.print(i + " ");
            }
        }

    }

}