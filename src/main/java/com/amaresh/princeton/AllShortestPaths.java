package com.amaresh.princeton;


/*************************************************************************
 *  Compilation:  javac AllShortestPaths.java
 *  Dependencies: Graph.java PathFinder.java In.java
 *  Execution:    java AllShortestPaths data.txt
 *  
 *  This PathFinder client builds a graph from edges read from a file,
 *  creates a PathFinder for each vertex, and reads source-destination
 *  requests from standard input and prints a shortest path in the
 *  graph from the source to the destination. This program is not
 *  feasible for use with huge graphs as the amount of space required
 *  to store all the PathFinder objects is quadratic in the number
 *  of graph vertices.
 *
 *  % java AllShortestPaths transportation.txt
 *  JFK LAX
 *    JFK  ORD  PHX  LAX
 *  LAS MCO
 *    LAS  DEN  ORD  ATL  MCO
 *  HOU JFK
 *    HOU  ATL  JFK
 *  
 *
 *************************************************************************/

public class AllShortestPaths {

    public static void main(String[] args) { 

        // read in graph from a file
        In in = new In(args[0]);
        Graph G = new Graph(in, " ");

        // compute shortest path from each vertex x
        ST<String, PathFinder> allpaths = new ST<String, PathFinder>(); 
        for (String s : G.vertices()) {
            allpaths.put(s, new PathFinder(G, s));
        } 

        // process source-destination queries from standard input
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            String t = StdIn.readString();
            for (String v : allpaths.get(s).pathTo(t)) {
                StdOut.print("  " + v);
            }
            StdOut.println();
        }
    }
}