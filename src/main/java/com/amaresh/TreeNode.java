package com.amaresh;

public class TreeNode {
    private Integer data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    TreeNode(Integer data) {
        this.data = data;
    }
    public Integer getData() {
        return data;
    }
    public TreeNode getLeftChild() {
        return leftChild;
    }
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }
    public TreeNode getRightChild() {
        return rightChild;
    }
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
    
    public TreeNode find(Integer data) {
        if(data == this.data) {
            return this;
        } else if(data < this.data && this.leftChild != null) {
            return this.leftChild.find(data);
        } else if(data > this.data && this.rightChild != null) {
            return this.rightChild.find(data);
        }
        return null;
    }
    
    public void insert(Integer data) {
        if(data < this.data) {
            if(this.leftChild == null) {
                this.leftChild = new TreeNode(data);
            } else {
                this.leftChild.insert(data);
            }
        } else {
            if(this.rightChild == null) {
                this.rightChild = new TreeNode(data);
            } else {
                this.rightChild.insert(data);
            }
        }
    }
    
    public void print() {
        //print left nodes recursively
        if(this.leftChild != null) {
            this.leftChild.print();
        } 

        //print root node
        System.out.print(this.data + "  ");
        
        //print right nodes recursively
        if(this.rightChild != null) {
            this.rightChild.print();
        }
        System.out.println();
    }
    
    public int getDepth(TreeNode node) {
        int leftDepth = 1;
        int rightDepth = 1;
        
        if(node.leftChild == null && node.rightChild == null) {
            return leftDepth;
        }
        if(node.leftChild != null) {
            leftDepth += getDepth(node.leftChild);
        }
        if(node.rightChild != null) {
            rightDepth += getDepth(node.rightChild);
        }
        
        if(leftDepth > rightDepth) {
            return leftDepth;
        } else {
            return rightDepth;
        }
    }

    public int[] getDeepest(TreeNode node) {
        int[] leftResult = new int[2]; // 0 = depth, 1 = data
        leftResult[0] = 1;
        leftResult[1] = node.getData();
        int[] rightResult = new int[2];
        rightResult[0] = 1;
        rightResult[1] = node.getData();
        
        if(node.leftChild == null && node.rightChild == null) {
            return leftResult;
        }
        if(node.leftChild != null) {
            leftResult = getDeepest(node.leftChild);
            leftResult[0] = leftResult[0] + 1;
        }
        if(node.rightChild != null) {
            rightResult = getDeepest(node.rightChild);
            rightResult[0] = rightResult[0] + 1;
        }
        
        
        if(leftResult[0] > rightResult[0]) {
            return leftResult;
        } else {
            return rightResult;
        }
    }
    
    public void delete(Integer data) {
        TreeNode nodeToDelete = this.find(data);
        if(nodeToDelete == null) {
            return;
        }
        //node is a leaf
        if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
            
        }
        
        //node has one child
        
        //node has two children
    }

}
