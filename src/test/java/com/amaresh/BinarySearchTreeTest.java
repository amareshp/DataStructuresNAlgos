package com.amaresh;

import org.testng.annotations.Test;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree bst = new BinarySearchTree(new Integer(0));
        
        bst.insert(1);
        bst.insert(40);
        bst.insert(35);
        bst.insert(51);
        bst.insert(13);
        bst.insert(65);
        bst.insert(21);
        bst.insert(70);
        bst.insert(77);
        bst.insert(99);
        /**
         *              0
         *                 1
         *                   40
         *                 35    51
         *              13          65
         *                 21           70
         *                                  77
         *                                      99
         */
        bst.print();
        //int depth = bst.getDepth();
        int[] result = bst.getDeepest();
        System.out.println("Depth = " + result[0] + " deepest: " + result[1]);
    }
}
