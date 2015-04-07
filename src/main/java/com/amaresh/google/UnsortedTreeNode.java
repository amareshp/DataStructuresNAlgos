package com.amaresh.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnsortedTreeNode {
    
    public Integer data;
    public UnsortedTreeNode leftChild;
    public UnsortedTreeNode rightChild;
    List<UnsortedTreeNode> preOrderList = null;
    public boolean rightToLeft = true;
    
    public UnsortedTreeNode(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
    public List<UnsortedTreeNode> inOrderTraverse() {
        List<UnsortedTreeNode> list = new ArrayList<UnsortedTreeNode>();
        Stack<UnsortedTreeNode> stack = new Stack<UnsortedTreeNode>();
        UnsortedTreeNode p = this;
        
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.leftChild;
            } else {
                UnsortedTreeNode t = stack.pop();
                list.add(t);
                p = t.rightChild;
            }
        }
        
        return list;
    }

    public List<UnsortedTreeNode> preOrderTraverse() {
        List<UnsortedTreeNode> list = new ArrayList<UnsortedTreeNode>();
        Stack<UnsortedTreeNode> stack = new Stack<UnsortedTreeNode>();
        stack.push(this);
        
        while(!stack.isEmpty()) {
            UnsortedTreeNode n = stack.pop();
            list.add(n);
            if(n.rightChild != null) {
                stack.push(n.rightChild);
            }
            if(n.leftChild != null) {
                stack.push(n.leftChild);
            }
        }
        
        return list;
    }
    
    public List<UnsortedTreeNode> inOrderTraverseRecursive(UnsortedTreeNode node, List<UnsortedTreeNode> iList) {
        if(node == null) {
            return iList;
        }
        if(node.leftChild != null) {
            inOrderTraverseRecursive(node.leftChild, iList);
        }
        iList.add(node);
        if(node.rightChild != null) {
            inOrderTraverseRecursive(node.rightChild, iList);
        }
        
        return iList;
    }

    public List<UnsortedTreeNode> preOrderTraverseRecursive(UnsortedTreeNode node, List<UnsortedTreeNode> iList) {
        if(node == null) {
            return iList;
        }
        iList.add(node);
        if(node.leftChild != null) {
            preOrderTraverseRecursive(node.leftChild, iList);
        }
        if(node.rightChild != null) {
            preOrderTraverseRecursive(node.rightChild, iList);
        }
        
        return iList;
    }
    
    public UnsortedTreeNode formNode(List<UnsortedTreeNode> inOrderList) {
        if(inOrderList.size() == 1) {
            return inOrderList.get(0);
        }
        int rootIndex = findRoot(inOrderList);
        UnsortedTreeNode root = inOrderList.get(rootIndex);
        preOrderList.remove(0);
        List<UnsortedTreeNode> left = null;
        List<UnsortedTreeNode> right = null;
        if(rootIndex > 0) {
            left = inOrderList.subList(0, rootIndex);
        }
        if( rootIndex < (inOrderList.size()-1) ) {
            right = inOrderList.subList(rootIndex+1, inOrderList.size());
        }
        if(left == null) {
            root.leftChild = null;
        } else {
            if(left.size() == 1) {
                root.leftChild = left.get(0);
                preOrderList.remove(0);
            } else {
                root.leftChild = formNode(left);
            }
        }
        if(right == null) {
            root.rightChild = null;
        } else {
            if(right.size() == 1) {
                root.rightChild = right.get(0);
                preOrderList.remove(0);
            } else {
                root.rightChild = formNode(right);
            }
        }
        return root;
    }
    
    private int findRoot(List<UnsortedTreeNode> inOrderList) {
        
        UnsortedTreeNode parent = preOrderList.get(0);
        int rIndex = 0;
        for(int i=0; i<inOrderList.size(); i++) {
            if(inOrderList.get(i).data.intValue() == parent.data.intValue()) {
                rIndex = i;
                break;
            }
        }
        return rIndex;
    }
    
    public void printTreeNodeLR(ArrayList<UnsortedTreeNode> list) {
        if(list.size() == 0) {
            return;
        }
        //print the list
        if(rightToLeft) {
            for(int i = list.size()-1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
        System.out.println();
        //flip rightToLeft
        if(rightToLeft) {
            rightToLeft = false;
        } else {
            rightToLeft = true;
        }
        
        ArrayList<UnsortedTreeNode> nextRow = new ArrayList<UnsortedTreeNode>();
        for(UnsortedTreeNode node : list) {
            if(node.leftChild != null) {
                nextRow.add(node.leftChild);
            }
            if(node.rightChild != null) {
                nextRow.add(node.rightChild);
            }
        }
        
        if(nextRow.size() > 0) {
            printTreeNodeLR(nextRow);
        }
    }
}
