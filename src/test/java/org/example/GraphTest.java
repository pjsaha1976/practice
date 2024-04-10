package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void addEdge() {
        //given
        Graph g = new Graph(4);
        //when
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 0, 4);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 1, 6);

        //then
        g.print();
    }

    @Test
    void dfs(){
        //given
        Graph g = new Graph(4);
        //when
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 0, 4);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 1, 6);

        //when
        g.dfs(0);

        //then

    }

    @Test
    void bfs(){
        //given
        Graph g = new Graph(4);
        //when
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 0, 4);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 1, 6);

        //when
        g.bfs(0);


        //then

    }

    @Test
    void dijkstra() {
            //given
            Graph g = new Graph(4);
            //when
            g.addEdge(0, 1, 3);
            g.addEdge(0, 2, 4);
            g.addEdge(1, 2, 1);
            g.addEdge(2, 3, 5);
            g.addEdge(3, 1, 6);

            //when
            int[] result = g.dijkstra(0);


            //then
        for (int i = 0; i < result.length; i++) {
            System.out.println(i + ":" + result[i]);
        }


        }
}