package com.amaresh.google;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class UnsortedTreeNodeTest {
    /**
     *                      10
     *                12           11
     *            14     13      9     18
     *           4   5  7   8   1  2  3   6
     */
    @Test
    public void inOrderTraverse() {
        UnsortedTreeNode lNode = new UnsortedTreeNode(14);
        lNode.leftChild = new UnsortedTreeNode(4);
        lNode.rightChild = new UnsortedTreeNode(5);
        
        UnsortedTreeNode rNode = new UnsortedTreeNode(13);
        rNode.leftChild = new UnsortedTreeNode(7);
        rNode.rightChild = new UnsortedTreeNode(8);
        
        UnsortedTreeNode root1 = new UnsortedTreeNode(12);
        root1.leftChild = lNode;
        root1.rightChild = rNode;
        
        UnsortedTreeNode lNode1 = new UnsortedTreeNode(9);
        lNode1.leftChild = new UnsortedTreeNode(1);
        lNode1.rightChild = new UnsortedTreeNode(2);
        
        UnsortedTreeNode rNode1 = new UnsortedTreeNode(18);
        rNode1.leftChild = new UnsortedTreeNode(3);
        rNode1.rightChild = new UnsortedTreeNode(6);
        
        UnsortedTreeNode root2 = new UnsortedTreeNode(11);
        root2.leftChild = lNode1;
        root2.rightChild = rNode1;
        
        UnsortedTreeNode root = new UnsortedTreeNode(10);
        root.leftChild = root1;
        root.rightChild = root2;

        //printLR
        ArrayList<UnsortedTreeNode> nList = new ArrayList<UnsortedTreeNode>();
        nList.add(root);
        root.printTreeNodeLR(nList);
        
        System.out.println("In order traversal using stack....");
        List<UnsortedTreeNode> inOrderList = root.inOrderTraverse();
        for(UnsortedTreeNode node : inOrderList) {
            System.out.print(node.data + "  ");
        }
        System.out.println();
        
        System.out.println("In order traversal using recursion....");
        List<UnsortedTreeNode> iList = new ArrayList<UnsortedTreeNode>();
        List<UnsortedTreeNode> inOrderListR = root.inOrderTraverseRecursive(root, iList);
        for(UnsortedTreeNode node : inOrderListR) {
            System.out.print(node.data + "  ");
        }
        System.out.println();
        
        System.out.println("Pre-order traversal using stack....");
        List<UnsortedTreeNode> preOrderList = root.preOrderTraverse();
        for(UnsortedTreeNode node : preOrderList) {
            System.out.print(node.data + "  ");
        }
        System.out.println();
        
        System.out.println("Pre-order traversal using recursion....");
        iList = new ArrayList<UnsortedTreeNode>();
        List<UnsortedTreeNode> preOrderListR = root.preOrderTraverseRecursive(root, iList);
        for(UnsortedTreeNode node : preOrderListR) {
            System.out.print(node.data + "  ");
        }
        System.out.println();
        
        root.preOrderList = preOrderList;
        UnsortedTreeNode reConstructed = root.formNode(inOrderList);
        System.out.println("In order traversal of reconstructed tree using stack....");
        List<UnsortedTreeNode> inOrderListRecon = reConstructed.inOrderTraverse();
        for(UnsortedTreeNode node : inOrderListRecon) {
            System.out.print(node.data + "  ");
        }
        System.out.println();
        
    }

}
