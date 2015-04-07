package com.amaresh.p1;

import java.util.ArrayList;

public class TreeNode1 {
    public Integer data;
    public int depth;
    public TreeNode1 leftChild;
    public TreeNode1 rightChild;
    
    public TreeNode1(Integer data) {
        this.data = data;
    }
    
    public String toString() {
        return String.valueOf(data);
    }
    
    public void traverseInOrder() {
        if(this.leftChild != null) this.leftChild.traverseInOrder();
        System.out.print(this + " ");
        if(this.rightChild != null) this.rightChild.traverseInOrder();
    }

    public void traversePreOrder() {
        System.out.print(this + " ");
        if(this.leftChild != null) this.leftChild.traversePreOrder();
        if(this.rightChild != null) this.rightChild.traversePreOrder();
    }

    public void traversePostOrder() {
        if(this.leftChild != null) this.leftChild.traversePostOrder();
        if(this.rightChild != null) this.rightChild.traversePostOrder();
        System.out.print(this + " ");
    }

    public void insertFromPreOrder(int[] preOrder, int current, int[] left, int[] right) {
        if(left.length == 1) {
            this.leftChild = new TreeNode1(preOrder[current]);
            current++;
        }
        if(left.length > 1 && current < preOrder.length) {
            this.leftChild = new TreeNode1(preOrder[current]);
            int i = 0;
            while(i < left.length && left[i] != preOrder[current]) i++;
            int[] newLeft = getLeftArray(left, i);
            int[] newRight = getRightArray(left, i);
            current++;
            this.leftChild.insertFromPreOrder(preOrder, current, newLeft, newRight);
        }
        if(right.length == 1) {
            this.rightChild = new TreeNode1(preOrder[current]);
            current++;
        }
        if(right.length > 0 && current < preOrder.length) {
            this.rightChild = new TreeNode1(preOrder[current]);
            int i = 0;
            while(i < right.length && right[i] != preOrder[current]) i++;
            int[] newLeft = getLeftArray(right, i);
            int[] newRight = getRightArray(right, i);
            current++;
            this.rightChild.insertFromPreOrder(preOrder, current, newLeft, newRight);
        } 
        
    }
    
    public int[] getLeftArray(int[] array, int parent) {
        if(array.length == 0) return array;
        int[] left = new int[parent];
        for(int i=0; i<left.length; i++) {
            left[i] = array[i];
        }
        return left;
    }
    public int[] getRightArray(int[] array, int parent) {
        if(array.length == 0 || parent > (array.length - 1) ) return new int[] {};
        int[] right = new int[array.length -1 - parent];
        for(int i=0; i<right.length; i++) {
            right[i] = array[parent + 1 +i];
        }
        return right;
    }
    
    public void insert(Integer data) {
        if(data < this.data) {
            if(this.leftChild == null) {
                this.leftChild = new TreeNode1(data);
            } else {
                this.leftChild.insert(data);
            }
        } else {
            if(this.rightChild == null) {
                this.rightChild = new TreeNode1(data);
            } else {
                this.rightChild.insert(data);
            }
        }
    }
    
    public TreeNode1 find(Integer data) {
        if(this.data == data) return this;
        if(data < this.data) {
            if(this.leftChild != null) {
                return this.leftChild.find(data);
            } else {
                return null;
            }
        } else {
            if(this.rightChild != null) {
                return this.rightChild.find(data);
            } else {
                return null;
            }
        }
    }
    
    public TreeNode1 smallest() {
        if(this.leftChild == null) {
            return this;
        } else {
            return this.leftChild.smallest();
        }
    }

    public TreeNode1 largest() {
        if(this.rightChild == null) {
            return this;
        } else {
            return this.rightChild.largest();
        }
    }
    
    public void printLevels() {
        ArrayList<TreeNode1> nextLevel = new ArrayList<TreeNode1>();
        nextLevel.add(this);
        depth = 0;
        printLevels(nextLevel);
    }
    
    public void printLevels(ArrayList<TreeNode1> nodes) {
        if(nodes == null || nodes.size() == 0) return;
        depth++;
        ArrayList<TreeNode1> nextLevel = new ArrayList<TreeNode1>();
        for(TreeNode1 node : nodes) {
            System.out.print(node.data + " ");
            if(node.leftChild != null) nextLevel.add(node.leftChild);
            if(node.rightChild != null) nextLevel.add(node.rightChild);
        }
        System.out.println();
        printLevels(nextLevel);
    }

    
}
