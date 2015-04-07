package com.amaresh.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UnsortedTree {

    UnsortedTreeNode root;
    
    public UnsortedTree(Integer data) {
        root = new UnsortedTreeNode(data);
    }
    
    public UnsortedTree(UnsortedTreeNode node) {
        root = node;
    }

    public List<UnsortedTreeNode> inOrderTraverse() {
        List<UnsortedTreeNode> list = new ArrayList<UnsortedTreeNode>();
        Stack<UnsortedTreeNode> stack = new Stack<UnsortedTreeNode>();
        UnsortedTreeNode p = root;
        
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
    
    
    public List<UnsortedTreeNode> inOrderTraverseRecursive() {
        List<UnsortedTreeNode> empty = new ArrayList<UnsortedTreeNode>();
        List<UnsortedTreeNode> elements = inOrderTraverseRecursive(root, empty);
        return elements;
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

}
