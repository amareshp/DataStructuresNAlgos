package com.amaresh.p1;

import org.testng.annotations.Test;

public class BinarySearchTree1Test {
    
    @Test
    public void insertTest() {
        BinarySearchTree1 tree = new BinarySearchTree1(25);
        tree.insert(10);
        tree.insert(50);
        tree.insert(6);
        tree.insert(12);
        tree.insert(46);
        tree.insert(54);
        tree.insert(5);
        tree.insert(8);
        tree.insert(11);
        tree.insert(13);
        tree.insert(40);
        tree.insert(48);
        tree.insert(51);
        tree.insert(56);
        
        tree.root.printLevels();
        System.out.println("finding 40: " + tree.find(40));
        System.out.println("finding 41: " + tree.find(41));
        System.out.println("depth of the tree = " + tree.root.depth);
        
        System.out.println("\nIn-order traversal");
        tree.traverseInOrder();
        
        System.out.println("\nPre-order traversal");
        tree.traversePreOrder();
        
        System.out.println("\nPost-order traversal");
        tree.traversePostOrder();
        
        int[] inOrder = new int[] {5, 6, 8, 10, 11, 12, 13, 25, 40, 46, 48, 50, 51, 54, 56};
        int[] preOrder = new int[] {25, 10, 6, 5, 8, 12, 11, 13, 50, 46, 40, 48, 54, 51, 56};
        BinarySearchTree1 tree2 = new BinarySearchTree1(preOrder, inOrder);
        System.out.println("\nIn-order traversal");
        tree2.traverseInOrder();
        System.out.println();
    }

}
