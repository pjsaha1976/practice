package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void addEdge() {
        //given
        Graph g = new Graph(4);
        //when
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        //then
        g.print();
    }

    @Test
    void dfs(){
        //given
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        //when
        g.dfs(0);

        //then

    }

    @Test
    void bfs(){
        //given
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(3, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(5, 1);
        //when
        g.bfs(0);

        //then

    }
}