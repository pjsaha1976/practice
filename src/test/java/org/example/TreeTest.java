package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void add()
    {
        //given
        Tree tree = new Tree();

        //when
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //then
        boolean result = tree.search(new TreeNode(1), tree.getRoot());
        assertTrue(result);
        result = tree.search(new TreeNode(5), tree.getRoot());
        assertTrue(result);
        result = tree.search(new TreeNode(3), tree.getRoot());
        assertTrue(result);
        result = tree.search(new TreeNode(2), tree.getRoot());
        assertTrue(result);
        result = tree.search(new TreeNode(7), tree.getRoot());
        assertTrue(result);

    }

    @Test
    void remove()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //when
        tree.remove(new TreeNode(2),tree.getRoot());

        //then
        boolean result = tree.search(new TreeNode(2), tree.getRoot());
        assertFalse(result);
        tree.inorder(tree.getRoot());

    }
    @Test
    void search()
    {
        //given
        Tree tree = new Tree();

        //when
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //then
        boolean result = tree.search(new TreeNode(1), tree.getRoot());
        assertTrue(result);

    }

    @Test
    void findTotalLevels()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //when
        int result = tree.findTotalLevels(tree.getRoot());

        //then
        assertEquals(4,result);

    }

    @Test
    void bfsByLevels()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());
        tree.add(new TreeNode(0),tree.getRoot());
        tree.add(new TreeNode(4),tree.getRoot());
        tree.add(new TreeNode(6),tree.getRoot());
        tree.add(new TreeNode(8),tree.getRoot());


        //when
        tree.bfsByLevel(tree.getRoot());

        //then
    }


    @Test
    void bfs()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //when

        //then
        tree.bfs(tree.getRoot());
    }

    @Test
    void inorder()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //when


        //then
        tree.inorder(tree.getRoot());



    }
    @Test
    void preorder()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //when


        //then
        tree.preorder(tree.getRoot());

    }
    @Test
    void postorder()
    {
        //given
        Tree tree = new Tree();
        tree.add(new TreeNode(1),tree.getRoot());
        tree.add(new TreeNode(5),tree.getRoot());
        tree.add(new TreeNode(3),tree.getRoot());
        tree.add(new TreeNode(2),tree.getRoot());
        tree.add(new TreeNode(7),tree.getRoot());

        //when


        //then
        tree.postorder(tree.getRoot());

    }

}