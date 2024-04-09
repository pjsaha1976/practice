package org.example;

import java.util.ArrayList;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public TreeNode getRoot()
    {
        return this.root;
    }
    //add a node
    public void add(TreeNode node, TreeNode head) {
        if (root == null) { root = node; return;} //empty tree

        //tree has nodes
        if (node.val < head.val)
        {
            if (head.left == null) {
                head.left = node;
                return;
            }
            add(node,head.left);

        }
        else {
            if (head.right == null) {
                head.right = node;
                return;
            }
            add(node,head.right);
        }
    }

    public TreeNode remove(TreeNode node, TreeNode head) {
        //empty tree
        if (head == null) { return head; }

        //removing root node
        if (root.val == node.val) { root = getTreeNode(node, root); return root;}

        //non empty tree
        if (node.val < head.val) {
            head.left = remove(node,head.left);
            return head;
        }
        else  if (node.val > head.val)  {
            head.right = remove(node,head.right);
            return head;
        }
        else { //match found
            return getTreeNode(node, head);

        }
    }

    private TreeNode getTreeNode(TreeNode node, TreeNode head) {
        if (head.left == null && head.right == null) { //node with no children
            return null;
        }
        else if (head.left == null) { //node with no left child
            return head.right;
        }
        else if (head.right == null) { //node with no right child
            return head.left;
        }
        else  { //node with both right + left child
            //attach the left child tree to the leftmost node of the right child tree
            TreeNode temp = head.right;
            while (temp.left != null) { temp = temp.left; }
            temp.left = head.left;

            return head.right;
        }
    }

    public boolean search(TreeNode node, TreeNode root){
        if (root == null) { return false;} //empty tree
        //tree not empty
        if (root.val == node.val) {
            return true;
        }
        if (root.val > node.val) {
            return search(node, root.left);
        }
        else return search(node, root.right);
    }

    //in order traversal
    public void inorder(TreeNode node)
    {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.val);
        inorder(node.right);
    }

    public void postorder(TreeNode node){
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.val);

    }

    public void preorder(TreeNode node){
        if (node == null) return;
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);

    }

    public void bfs(TreeNode node) {
        //empty tree
        if (node == null) return;
        //non-empty tree
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(node);
        bfsRecursive(list);
    }

    private void bfsRecursive(ArrayList<TreeNode> list) {

            if (list.isEmpty()) return;

            TreeNode temp = list.removeFirst();
            System.out.println(temp.val);
            if (temp.left != null) list.add(temp.left);
            if (temp.right != null) list.add(temp.right);
            bfsRecursive(list);
    }

    public int findTotalLevels(TreeNode node)
    {
        if (node == null) return 0;

        return 1+ Math.max(findTotalLevels(node.left), findTotalLevels(node.right));

    }

    public void bfsByLevel(TreeNode node)
    {
       int totalLevel = findTotalLevels(node);
       for (int i = 1; i <= totalLevel; i++) {
           System.out.println("Level " + i);
           printByLevel(node,i);
       }
    }

    private void printByLevel(TreeNode node, int level){
        if (node == null) return;
        if (level == 1) System.out.println(node.val);
        else {
            printByLevel(node.left, level - 1);
            printByLevel(node.right, level - 1);

        }

    }

}
