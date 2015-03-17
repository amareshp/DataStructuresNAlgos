package com.amaresh;

public class BinarySearchTree {
    private TreeNode root;
    
    public BinarySearchTree(Integer data) {
        TreeNode root = new TreeNode(data);
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void insert(Integer data) {
        root.insert(data);
    }
    
    public void print() {
        root.print();
    }
    
    public int getDepth() {
        return root.getDepth(root);
    }

    public int[] getDeepest() {
        return root.getDeepest(root);
    }
    
}
