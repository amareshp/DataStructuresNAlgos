package com.amaresh.fb;

import java.util.ArrayList;
import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class CombinationsTest {

    @Test
    public void test() {
        //Combinations c = new Combinations();
        int[] set = new int[] {3, 5, 9};
        //Combinations.getSubsets(set, 2);
        //Combinations.printThreeElementSubsets(set);
        ArrayList<LinkedHashSet<Integer>> sets = Combinations.getSubsetsK(set, 2);
        print1(sets);
    }
    
    private static void print1(ArrayList<LinkedHashSet<Integer>> sets) {
        for(LinkedHashSet<Integer> setVar : sets) {
            for(Integer i : setVar) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
