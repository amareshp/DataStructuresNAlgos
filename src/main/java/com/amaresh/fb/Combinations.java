package com.amaresh.fb;

//This is a java program to generate all subsets containing exactly K elements in it
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Combinations {
    public static void getSubsets(int[] sequence, int elementsInSubset) {
        int N = sequence.length;
        System.out.println("The elements in the set : ");
        for (int i = 0; i < N; i++)
            System.out.print(sequence[i] + " ");

        System.out.println();
        int n = elementsInSubset;

        int[] binary = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < Math.pow(2, N); i++) {
            int b = 1;
            binary[i] = 0;
            int num = i, count = 0;
            while (num > 0) {
                if (num % 2 == 1)
                    count++;
                binary[i] += (num % 2) * b;
                num /= 2;
                b = b * 10;
            }
            if (count == n) {
                System.out.print("{ ");
                for (int j = 0; j < N; j++) {
                    if (binary[i] % 10 == 1)
                        System.out.print(sequence[j] + " ");
                    binary[i] /= 10;
                }
                System.out.println("}");
            }
        }

    }
    
    public static void printThreeElementSubsets(int[] s) {
        int n = s.length;
        for (int mask = 0; mask < (1 << n); ++mask) {
            if (Integer.bitCount(mask) == 2) {
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << (n-1-i))) != 0)
                        System.out.print(s[i] + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static ArrayList<LinkedHashSet<Integer>> getSubsetsK(int[] s, int k) {
        int n = s.length;
        ArrayList<LinkedHashSet<Integer>> sets = new ArrayList<LinkedHashSet<Integer>>();
        for (int mask = 0; mask < (1 << n); ++mask) {
            if (Integer.bitCount(mask) == k) {
                LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
                for (int i = 0; i < n; ++i) {
                    if ((mask & (1 << (n-1-i))) != 0) {
                        set.add(s[i]);
                        //System.out.print(s[i] + " ");
                    }
                }
                sets.add(set);
                //System.out.println();
            }
        }
        return sets;
    }    
    
}