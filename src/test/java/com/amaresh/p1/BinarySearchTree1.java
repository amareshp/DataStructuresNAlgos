package com.amaresh.p1;

public class BinarySearchTree1 {
    
    TreeNode1 root;
    
    public BinarySearchTree1(Integer data) {
        root = new TreeNode1(data);
    }

    public BinarySearchTree1(int[] preOrder, int[] inOrder) {
        root = new TreeNode1(preOrder[0]);
        int parent = 0;
        while(inOrder[parent] != preOrder[0]) parent++;
        int[] left = root.getLeftArray(inOrder, parent);
        int[] right = root.getRightArray(inOrder, parent);
        root.insertFromPreOrder(preOrder, 1, left, right);
        root.printLevels();
    }
    
    public void traverseInOrder() {
        if(root != null) root.traverseInOrder();
    }

    public void traversePreOrder() {
        if(root != null) root.traversePreOrder();
    }
    
    public void traversePostOrder() {
        if(root != null) root.traversePostOrder();
    }
    
    public void insert(Integer data) {
        if(root == null) {
            root = new TreeNode1(data);
        } else {
            root.insert(data);
        }
    }
    
    public TreeNode1 find(Integer data) {
        if(root == null) return null;
        return root.find(data);
    }
    
    public void delete(Integer data) {
        if(root == null) return;
        TreeNode1 parent = root;
        TreeNode1 current = root;
        boolean isLeft = true;
        
        while(current != null && current.data != data) {
            parent = current;
            if(data < root.data) {
                current = root.leftChild;
                isLeft = true;
            } else {
                current = root.rightChild;
                isLeft = false;
            }
        }
        
        //not found
        if(current == null) return;
        
        //leaf node
        if(current.leftChild == null && current.rightChild == null) {
            if(isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        
        //node to be deleted has only one child
        else if(current.rightChild == null) {
            if(isLeft) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        else if(current.leftChild == null) {
            if(isLeft) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        
        //node to be deleted has two children
        else {
            TreeNode1 successor = current.rightChild.smallest();
            successor.leftChild = current.leftChild;
            successor.rightChild = current.rightChild;
            if(isLeft) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
        }
    }
    

}
